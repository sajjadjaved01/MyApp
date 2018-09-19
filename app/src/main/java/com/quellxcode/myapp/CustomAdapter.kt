package com.quellxcode.myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.quellxcode.myapp.CustomAdapter.ViewHolder

class CustomAdapter(val Items: List<Custom> = ArrayList()) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layout = LayoutInflater.from(p0.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(layout, R.layout.adapter_items, p0, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = Items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(Items[p1])
    }


    class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.listItems, data)
            binding.executePendingBindings()
        }
    }
}