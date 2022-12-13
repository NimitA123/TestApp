package com.example.test.database.localDatabase

import com.example.test.model.ResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService{
    @GET("categories")
    suspend fun getDetails() : Response<ResponseDTO>
}