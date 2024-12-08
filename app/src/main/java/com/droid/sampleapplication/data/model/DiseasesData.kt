package com.droid.sampleapplication.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DiseasesData(
    @Json(name = "description")
    val description: String,

    @Json(name = "id")
    val id: Int,

    @Json(name = "lab_tests")
    val labTests: List<LabTest>,

    @Json(name = "medications")
    val medications: List<Medication>,

    @Json(name = "name")
    val name: String,

    @Json(name = "symptoms")
    val symptoms: List<String>
)