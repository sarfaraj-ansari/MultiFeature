package com.example.draggablerecyclerview

import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.Transformation

fun View.expand() {
    val matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec((this.parent as View).width, View.MeasureSpec.EXACTLY)
    val wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.EXACTLY)
    this.measure(matchParentMeasureSpec, wrapContentMeasureSpec)
    val targetWidth: Int = this.measuredWidth

    this.layoutParams.width = 1
    this.visibility = View.VISIBLE
    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
            this@expand.layoutParams.width =
                if (interpolatedTime == 1f) WindowManager.LayoutParams.WRAP_CONTENT else (targetWidth * interpolatedTime).toInt()
            this@expand.requestLayout()
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }

    a.duration = (targetWidth / this.context.resources.displayMetrics.density).toLong()
    this.startAnimation(a)

}

fun View.collapse() {
    val initialWidth: Int = this.measuredWidth

    val a: Animation = object : Animation() {
        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            if (interpolatedTime == 1f) {
                this@collapse.visibility = View.GONE
            } else {
                this@collapse.layoutParams.width =
                    initialWidth - (initialWidth * interpolatedTime).toInt()
                this@collapse.requestLayout()
            }
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }

    a.duration = (initialWidth / this.context.resources.displayMetrics.density).toLong()
    this.startAnimation(a)
}