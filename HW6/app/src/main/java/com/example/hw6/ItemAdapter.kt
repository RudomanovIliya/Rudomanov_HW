package com.example.hw6

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ItemAdapter : Adapter<ViewHolder>() {
    companion object {
        private const val SMALL_ITEM = 0
        private const val BIG_ITEM = 1
    }

    private val items = mutableListOf<AdapterItem>()
    lateinit var itemListener: ItemListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            SMALL_ITEM -> SmallItemViewHolder(parent, itemListener)
            BIG_ITEM -> BigItemViewHolder(parent, itemListener)
            else -> throw Exception("incorrect view type")
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            SMALL_ITEM -> (holder as SmallItemViewHolder).bind(items[position] as SmallItem)
            BIG_ITEM -> (holder as BigItemViewHolder).bind(items[position] as BigItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is SmallItem) SMALL_ITEM else BIG_ITEM
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<AdapterItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun deleteItem(item: AdapterItem, items: MutableList<AdapterItem>): MutableList<AdapterItem> {
        val position = items.indexOf(item)
        items.remove(item)
        this.items.remove(item)
        notifyItemRemoved(position)
        return items
    }

    fun addItem(item: AdapterItem, items: MutableList<AdapterItem>): MutableList<AdapterItem> {
        items.add(item)
        this.items.add(item)
        notifyItemChanged(items.size)
        return items
    }
}