package com.example.test.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test.database.localDatabase.ApiService
import com.example.test.model.ResponseDTO

class Repository(private val apiService: ApiService) {
    var apiData = MutableLiveData<ResponseDTO>()
    val liveData: LiveData<ResponseDTO>
        get() = apiData
    suspend fun getRetrofit() {
        val response = apiService.getDetails()
        if (response.body() != null) {
            apiData.postValue(response.body())
        }
    }
}
