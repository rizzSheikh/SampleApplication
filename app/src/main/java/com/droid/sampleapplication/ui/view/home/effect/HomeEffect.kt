package com.droid.sampleapplication.ui.view.home.effect

import com.droid.sampleapplication.data.model.DiseasesData

sealed interface HomeEffect {
    data class NavigateToDetails(val diseasesData: DiseasesData) : HomeEffect
}