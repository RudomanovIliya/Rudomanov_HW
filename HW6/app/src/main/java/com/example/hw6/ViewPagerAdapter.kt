package com.example.hw6

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter

class ViewPagerAdapter : Adapter<ViewPagerViewHolder>() {
    private val items = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        return ViewPagerViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}