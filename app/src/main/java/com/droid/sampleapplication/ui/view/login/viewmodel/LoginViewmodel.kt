package com.droid.sampleapplication.ui.view.login.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droid.sampleapplication.data.local.LoginInfo
import com.droid.sampleapplication.data.local.LoginInfoDao
import com.droid.sampleapplication.ui.view.login.effect.LoginEffect
import com.droid.sampleapplication.ui.view.login.event.LoginEvent
import com.droid.sampleapplication.ui.view.login.uistate.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor(
    private val loginDao: LoginInfoDao
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())

    val uiState = _uiState.asStateFlow()

    private val _effect by lazy { Channel<LoginEffect>() }

    val effect: Flow<LoginEffect> by lazy { _effect.receiveAsFlow() }

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnLogInClick -> loginUser(
                email = event.userId,
                password = event.password
            )
        }
    }

    private fun loginUser(email: String, password: String) {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            loginDao.insertLoginInfo(LoginInfo(isLoggedIn = true, userName = email))
            delay(2100)
            _uiState.update { it.copy(isLoading = false) }
            _effect.send(LoginEffect.NavigateToHome)
        }
    }
}