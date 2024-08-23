package com.example.draggablerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var items: List<Int>) :
    RecyclerView.Adapter<CustomAdapter.RowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rec_view2, parent, false)
        return RowViewHolder(view)
    }

    override fun onBindViewHolder(holder: RowViewHolder, position: Int) {
        val rowItems = getRowItems(position)
        holder.bind(rowItems)
    }

    override fun getItemCount(): Int {
        return (items.size + 2) / 3
    }

    private fun getRowItems(position: Int): List<Int> {
        val startIndex = position * 3
        val endIndex = (startIndex + 3).coerceAtMost(items.size)
        return items.subList(startIndex, endIndex)
    }

    class RowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView1: ImageView = itemView.findViewById(R.id.img1)
        private val imageView2: ImageView = itemView.findViewById(R.id.img2)
        private val imageView3: ImageView = itemView.findViewById(R.id.img3)

        fun bind(rowItems: List<Int>) {
            if (rowItems.isNotEmpty()) {
                imageView1.setImageResource(rowItems[0])
                imageView1.visibility = View.VISIBLE
                if (rowItems.size > 1) {
                    imageView2.setImageResource(rowItems[1])
                    imageView2.visibility = View.VISIBLE
                    if (rowItems.size > 2) {
                        imageView3.setImageResource(rowItems[2])
                        imageView3.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}