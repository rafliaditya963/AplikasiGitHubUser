package com.example.aplikasigithubuser.data.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Headers

class ApiConfig {
    companion object{
        fun getApiService(): ApiService {
            val authInterceptor = Interceptor { chain ->
                val req = chain.request()
                val requestHeaders = req.newBuilder()
                    .addHeader("Authorization", "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")
                    .build()
                chain.proceed(requestHeaders)
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(authInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}