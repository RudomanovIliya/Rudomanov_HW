package com.example.hw6

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.hw6.databinding.ActivityMainBinding
import com.example.hw6.extension.toPx
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = ItemAdapter()
        val recyclerView = binding.recyclerViewItem
        var checkItem = true
        val viewPager = binding.viewPager
        val viewPagerAdapter = ViewPagerAdapter()
        viewPager.adapter = viewPagerAdapter
        viewPagerAdapter.setItems(
            listOf(
                "item 1",
                "item 2",
                "item 3",
                "item 4",
                "item 5",
            )
        )
        TabLayoutMediator(
            binding.tabLayoutItem,
            viewPager
        ) { tab, position ->
            tab.icon = when (position) {
                0 -> resources.getDrawable(R.drawable.tab_indicator_selected)
                1 -> resources.getDrawable(R.drawable.tab_indicator_selected)
                2 -> resources.getDrawable(R.drawable.tab_indicator_selected)
                3 -> resources.getDrawable(R.drawable.tab_indicator_selected)
                4 -> resources.getDrawable(R.drawable.tab_indicator_selected)
                else -> throw IllegalStateException()
            }
        }.attach()
        val items = mutableListOf(
            *listOf(
                SmallItem("item 1"),
                SmallItem("item 2"),
                SmallItem("item 3")
            ).toTypedArray(),
            *listOf(
                BigItem("item 1"),
                BigItem("item 2"),
                BigItem("item 3"),
            ).toTypedArray(),
        )
        recyclerView.adapter = adapter.apply {
            itemListener = ItemListener { item ->
                deleteItem(item, items)
            }
        }
        binding.buttonAdd.setOnClickListener {
            if (checkItem) {
                checkItem = !checkItem
                adapter.addItem(SmallItem("item 1"), items)
            } else {
                checkItem = !checkItem
                adapter.addItem(BigItem("item 1"), items)
            }
        }
        recyclerView.addItemDecoration(RecyclerViewItemDecoration(6.toPx()))
        adapter.setItems(items)
    }
}