package com.example.assignmet.Retrofit

import okhttp3.Interceptor
import okhttp3.Response

// AuthInterceptor.kt
class AuthInterceptor : Interceptor {
    private val hardcodedToken = "00D6t000000oDtZ!AQEAQD6Iw6EFKd0FH7fcOraHyCgD1npu84Mp4wFoips6VvoBqlOC0QzYfB3ccea2dqnYQtvIzHCirjUQGSA_b3BiQaYLS76l"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .header("Authorization", "Bearer $hardcodedToken")
            .build()
        return chain.proceed(request)
    }
}
