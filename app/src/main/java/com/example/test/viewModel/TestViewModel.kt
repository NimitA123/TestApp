package com.example.test.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.model.ResponseDTO
import com.example.test.repo.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class TestViewModel(private val repository: Repository) : ViewModel(){

    init{
        viewModelScope.launch(Dispatchers.IO) {
            repository.getRetrofit()
        }
    }


    val tastyData: LiveData<ResponseDTO>
    get() = repository.liveData


}

