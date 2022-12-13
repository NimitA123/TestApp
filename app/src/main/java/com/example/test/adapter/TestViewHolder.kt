package com.example.test.adapter


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.databinding.ItemLayoutBinding
import com.example.test.model.Data

class TestViewHolder(var itemLayoutBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(itemLayoutBinding.root) {
    fun setData(data: Data) {
        Glide.with(itemView).load(data.image).into(itemLayoutBinding.image)
        itemLayoutBinding.companyName.text = data.name
    }
}