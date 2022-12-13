package com.example.test.database.localDatabase

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object {
        private var httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        fun getResponse(): Retrofit {
            val retrofit =
                Retrofit.Builder().
                baseUrl("https://api.homedrop.in/").addConverterFactory(
                    GsonConverterFactory.create()
                ).client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
                    .build()
            return retrofit
        }
    }
}





