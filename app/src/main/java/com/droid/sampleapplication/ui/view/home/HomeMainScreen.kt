package com.droid.sampleapplication.ui.view.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.droid.sampleapplication.data.model.DiseasesData
import com.droid.sampleapplication.ui.view.home.effect.HomeEffect
import com.droid.sampleapplication.ui.view.home.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeMainScreen(viewmodel: HomeViewModel = hiltViewModel(), onItemClick: (DiseasesData) -> Unit) {
    val homeUiState = viewmodel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewmodel.effect.collectLatest { effect ->
            when (effect) {
                is HomeEffect.NavigateToDetails -> onItemClick(effect.diseasesData)
            }
        }
    }

    HomeScreen(uiState = homeUiState.value, onEvent = viewmodel::onEvent)
}