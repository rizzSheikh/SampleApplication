package com.droid.sampleapplication.network

import com.droid.sampleapplication.data.model.DiseasesResponseData
import retrofit2.http.GET

interface ApiService {

    @GET("/v3/49c64ab8-9819-4580-9574-803985a0cb4f")
    suspend fun getMedicines(): DiseasesResponseData

}