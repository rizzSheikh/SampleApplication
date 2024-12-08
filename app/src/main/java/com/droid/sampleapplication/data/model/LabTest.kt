package com.droid.sampleapplication.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LabTest(
    @Json(name = "description")
    val description: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String,

    @Json(name = "normal_range")
    val normalRange: String
)