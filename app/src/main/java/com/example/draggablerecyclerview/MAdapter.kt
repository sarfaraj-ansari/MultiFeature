package com.example.draggablerecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MAdapter(
    var imageList: ArrayList<Int>,
    private val onItemRemoved: (Int) -> Unit,
) : RecyclerView.Adapter<MAdapter.ViewH>(){

    inner class ViewH(itemView: View) : ViewHolder(itemView) {
        fun bind(image: Int) {
            val img = itemView.findViewById<ImageView>(R.id.img)
            img.setImageResource(image)
            img.setOnClickListener { onItemRemoved.invoke(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rec_view, parent, false)
        return ViewH(view)
    }

    override fun getItemCount() = imageList.size

    override fun onBindViewHolder(holder: ViewH, position: Int) {
        holder.bind(imageList[position])
    }

}