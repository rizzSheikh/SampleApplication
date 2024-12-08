package com.droid.sampleapplication.ui.view.home.event

import com.droid.sampleapplication.data.model.DiseasesData

sealed interface HomeEvent {
    data object OnRetryClicked : HomeEvent
    data object OnRefresh : HomeEvent
    data class OnItemClick(val item: DiseasesData) : HomeEvent
}