package com.example.draggablerecyclerview

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

interface DragHelper {

    fun onDrag(onMove: (Int, Int) -> Unit): ItemTouchHelper.SimpleCallback {

        val dragFlags =
            ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END or ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
        val itemTouchCallBack = object : ItemTouchHelper.SimpleCallback(dragFlags, 0) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                onMove.invoke(viewHolder.adapterPosition, target.adapterPosition)
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

        }

        return itemTouchCallBack

    }

}