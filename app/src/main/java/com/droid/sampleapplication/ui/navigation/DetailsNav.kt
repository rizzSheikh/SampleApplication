package com.droid.sampleapplication.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.droid.sampleapplication.data.model.DiseasesData
import com.droid.sampleapplication.ui.view.MainActivity.Companion.diseasesDataAdapter
import com.droid.sampleapplication.ui.view.details.DetailsMainScreen
import kotlinx.serialization.Serializable

@Serializable
data class DetailsNav(val diseasesData: String)

fun NavController.navigateToDetails(diseasesData: DiseasesData) {
    val json = diseasesDataAdapter.toJson(diseasesData)
    this.navigate(route = DetailsNav(json))
}

fun NavGraphBuilder.detailsScreen(onBackPress: () -> Unit) {
    composable<DetailsNav> {
        val arg = it.toRoute<DetailsNav>()
        diseasesDataAdapter.fromJson(arg.diseasesData)
            ?.let { data -> DetailsMainScreen(diseasesData = data, onBackPress = onBackPress) }
    }
}