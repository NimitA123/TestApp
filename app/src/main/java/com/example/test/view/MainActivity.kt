package com.example.test.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.R
import com.example.test.adapter.TestAdapter
import com.example.test.database.localDatabase.ApiService
import com.example.test.database.localDatabase.Network
import com.example.test.databinding.ActivityMainBinding
import com.example.test.model.Data
import com.example.test.repo.Repository
import com.example.test.viewModel.MainViewModel
import com.example.test.viewModel.TestViewModel


class MainActivity : AppCompatActivity() {
    private lateinit var testViewModel: TestViewModel
    private var responseDTO = arrayListOf<Data>()
    private lateinit var testAdapter: TestAdapter
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
        observer()
    }

    private fun observer() {
        testViewModel.tastyData.observe(this , Observer{
           responseDTO.addAll(it.data as ArrayList<Data>)
            setAdapter()
        })
    }

    private fun setAdapter() {
       testAdapter = TestAdapter(responseDTO)
        var linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val gridLayoutManager = GridLayoutManager(this, 2)
         activityMainBinding.recyclerView.apply {
                adapter = testAdapter
                layoutManager = gridLayoutManager
            }
    }

    private fun initView() {
        val apiService = Network.getResponse().create(ApiService::class.java)
        var repository:Repository = Repository(apiService)
        testViewModel = TestViewModel(repository)
        testViewModel = ViewModelProvider(this, MainViewModel(repository)).get(testViewModel::class.java)
    }
}

