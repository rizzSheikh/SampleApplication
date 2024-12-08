package com.droid.sampleapplication.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Medication(
    @Json(name = "description")
    val description: String,

    @Json(name = "dosage")
    val dosage: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "name")
    val name: String
)