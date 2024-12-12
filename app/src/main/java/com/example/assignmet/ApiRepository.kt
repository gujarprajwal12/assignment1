package com.example.assignmet

import com.example.assignmet.Data.Root
import com.example.assignmet.Retrofit.RetrofitClient
import retrofit2.Response

// ApiRepository.kt
class ApiRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getEventData(userId: String, appName: String): Response<Root> {
        return apiService.getEventData(userId, appName)
    }
}
