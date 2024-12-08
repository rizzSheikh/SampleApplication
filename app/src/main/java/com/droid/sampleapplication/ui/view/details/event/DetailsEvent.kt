package com.droid.sampleapplication.ui.view.details.event

sealed interface DetailsEvent {
    data object OnBackPress : DetailsEvent
}