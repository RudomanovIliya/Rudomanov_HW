package com.example.hw6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hw6.databinding.ViewPagerItemBinding

class ViewPagerViewHolder(parent: ViewGroup) : ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item, parent, false)
) {
    private val binding by viewBinding(ViewPagerItemBinding::bind)

    fun bind(text: String) {
        binding.textViewText.text = text
    }
}