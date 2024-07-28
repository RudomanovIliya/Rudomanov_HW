package com.example.hw6

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6.extension.toPx

class RecyclerViewItemDecoration (private var space: Int = 4.toPx()) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        outRect.left = space
        outRect.right = space
        outRect.top = space
        outRect.bottom = space
    }
}