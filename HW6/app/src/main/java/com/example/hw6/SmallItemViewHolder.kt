package com.example.hw6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hw6.databinding.SmallItemBinding

class SmallItemViewHolder(parent: ViewGroup, private val itemListener: ItemListener) : ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.small_item, parent, false)
) {
    private val binding by viewBinding(SmallItemBinding::bind)

    fun bind(item: SmallItem) = with(binding) {
        root.setOnClickListener {
            itemListener.onItemClick(item)
        }
        textViewText.text = item.text
    }
}