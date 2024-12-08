package com.droid.sampleapplication.ui.view.details

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.droid.sampleapplication.data.model.DiseasesData
import com.droid.sampleapplication.ui.view.details.viewmodel.DetailsViewModel

@Composable
fun DetailsMainScreen(
    diseasesData: DiseasesData,
    viewmodel: DetailsViewModel = hiltViewModel(),
    onBackPress: () -> Unit
) {
    DetailsScreen(diseasesData = diseasesData, onBackPress = onBackPress)
}