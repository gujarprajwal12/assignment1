package com.example.assignmet.Retrofit

import com.example.assignmet.Data.Root
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

// ApiService.kt
interface ApiService {
    @GET("apexrest/BLN_ASC_Events")
    suspend fun getEventData(
        @Query("User_id") userId: String,
        @Query("appname") appName: String
    ): Response<Root>
}
