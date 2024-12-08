package com.droid.sampleapplication.ui.view.login.effect

sealed interface LoginEffect {
    data object NavigateToHome : LoginEffect
}