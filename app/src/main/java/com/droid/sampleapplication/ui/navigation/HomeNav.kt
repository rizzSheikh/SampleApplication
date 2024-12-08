package com.droid.sampleapplication.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.droid.sampleapplication.data.model.DiseasesData
import com.droid.sampleapplication.ui.view.home.HomeMainScreen
import kotlinx.serialization.Serializable

@Serializable
data object HomeNav

fun NavController.navigateToHome() {
    this.navigate(route = HomeNav)
}

fun NavGraphBuilder.homeScreen(onItemClick: (DiseasesData) -> Unit) {
    composable<HomeNav> {
        HomeMainScreen(onItemClick = onItemClick)
    }
}