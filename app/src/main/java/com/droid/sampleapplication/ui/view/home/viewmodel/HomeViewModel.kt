package com.droid.sampleapplication.ui.view.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droid.sampleapplication.data.local.LoginInfoDao
import com.droid.sampleapplication.data.model.DiseasesData
import com.droid.sampleapplication.data.repository.MedicineRepository
import com.droid.sampleapplication.ui.view.home.effect.HomeEffect
import com.droid.sampleapplication.ui.view.home.event.HomeEvent
import com.droid.sampleapplication.ui.view.home.uistate.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MedicineRepository,
    private val loginInfoDao: LoginInfoDao
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    val uiState = _uiState.asStateFlow()

    private val _effect by lazy { Channel<HomeEffect>() }

    val effect: Flow<HomeEffect> by lazy { _effect.receiveAsFlow() }

    init {
        updateUserName()
        getDiseasesData()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnRetryClicked -> getDiseasesData()
            HomeEvent.OnRefresh -> getDiseasesData(isRefreshing = true)
            is HomeEvent.OnItemClick -> navigateToDetailsScreen(diseasesData = event.item)
        }
    }

    private fun updateUserName() {
        viewModelScope.launch {
            val userName = loginInfoDao.getLoginInfo()?.userName ?: "User"
            _uiState.update { it.copy(userName = userName) }
        }
    }

    private fun getDiseasesData(isRefreshing: Boolean = false) {
        _uiState.update {
            it.copy(
                isLoading = true,
                showErrorAndRetry = false,
                isRefreshing = isRefreshing
            )
        }
        viewModelScope.launch {
            repository.fetchDiseasesData().onSuccess { response ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        showErrorAndRetry = false,
                        diseasesResponseData = response,
                        isRefreshing = false
                    )
                }
            }.onFailure {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        showErrorAndRetry = true,
                        isRefreshing = false
                    )
                }
            }
        }
    }

    private fun navigateToDetailsScreen(diseasesData: DiseasesData) {
        viewModelScope.launch { _effect.send(HomeEffect.NavigateToDetails(diseasesData)) }
    }

}