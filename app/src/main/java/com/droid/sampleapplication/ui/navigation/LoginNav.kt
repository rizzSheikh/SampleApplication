package com.droid.sampleapplication.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droid.sampleapplication.ui.view.login.LoginMainScreen
import kotlinx.serialization.Serializable

@Serializable
data object LoginNav

fun NavController.navigateToLogin() {
    this.navigate(route = LoginNav) {
        popUpTo(0) {
            inclusive = true
        }
        launchSingleTop = true
        restoreState = false
    }
}

fun NavGraphBuilder.loginScreen(onLoginClick: () -> Unit) {
    composable<LoginNav>{
        LoginMainScreen(onLoginClick = onLoginClick)
    }
}