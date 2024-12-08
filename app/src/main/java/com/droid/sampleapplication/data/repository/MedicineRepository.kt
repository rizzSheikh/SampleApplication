package com.droid.sampleapplication.data.repository

import com.droid.sampleapplication.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MedicineRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun fetchDiseasesData() = withContext(Dispatchers.IO) {
        return@withContext try {
            Result.success(apiService.getMedicines())
        } catch (e: Throwable) {
            when (e) {
                is TimeoutCancellationException -> Result.failure(e)
                else -> Result.failure(e)
            }
        }
    }
}