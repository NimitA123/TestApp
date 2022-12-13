package com.example.test.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.DataBinderMapperImpl
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.model.Data

class TestAdapter(var responseDTO: ArrayList<Data>) : RecyclerView.Adapter<TestViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestViewHolder {
       return TestViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
       var data = responseDTO[position]
       holder.setData(data)
    }

    override fun getItemCount(): Int {
       return responseDTO.size
    }
}