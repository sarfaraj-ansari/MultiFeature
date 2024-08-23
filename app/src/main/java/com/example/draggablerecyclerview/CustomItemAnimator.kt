package com.example.draggablerecyclerview

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class CustomItemAnimator(context: Context) : DefaultItemAnimator() {

    private val addAnimation: AnimatorSet = AnimatorInflater.loadAnimator(context, R.animator.animator) as AnimatorSet

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        holder.itemView.translationX = -holder.itemView.rootView.width.toFloat()
        holder.itemView.animate()
            .translationX(0f)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .setDuration(500)
            .start()
        return super.animateAdd(holder)
    }
}
