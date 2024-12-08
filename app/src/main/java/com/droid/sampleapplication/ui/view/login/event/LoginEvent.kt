package com.droid.sampleapplication.ui.view.login.event

sealed interface LoginEvent {
    data class OnLogInClick(val userId: String, val password: String) : LoginEvent
}