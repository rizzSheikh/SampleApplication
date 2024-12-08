package com.droid.sampleapplication.ui.view.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.droid.sampleapplication.ui.view.login.effect.LoginEffect
import com.droid.sampleapplication.ui.view.login.viewmodel.LoginViewmodel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginMainScreen(
    viewmodel: LoginViewmodel = hiltViewModel(),
    onLoginClick: () -> Unit
) {
    val loginUiState = viewmodel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewmodel.effect.collectLatest { effect ->
            when (effect) {
                LoginEffect.NavigateToHome -> onLoginClick()
            }
        }
    }

    LoginScreen(onEvent = viewmodel::onEvent, uiState = loginUiState.value)
}