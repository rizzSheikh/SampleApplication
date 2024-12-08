package com.droid.sampleapplication.ui.view.home.uistate

import com.droid.sampleapplication.data.model.DiseasesResponseData


data class HomeUiState(
    val userName: String = "",
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val showErrorAndRetry: Boolean = false,
    val diseasesResponseData: DiseasesResponseData? = null
)
