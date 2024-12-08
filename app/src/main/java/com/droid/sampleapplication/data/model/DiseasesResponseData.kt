package com.droid.sampleapplication.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DiseasesResponseData(

    @Json(name = "diseases_data")
    val diseasesData: List<DiseasesData>
)