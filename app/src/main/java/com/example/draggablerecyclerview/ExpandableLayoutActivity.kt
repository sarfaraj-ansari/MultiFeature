package com.example.draggablerecyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ExpandableLayoutActivity : AppCompatActivity() {
    private lateinit var imgExpand: ImageView
    private lateinit var layoutShouldExpand: LinearLayout

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_layout)

        imgExpand = findViewById(R.id.ivExpandCollapse)
        layoutShouldExpand = findViewById(R.id.layoutExpandable)

        imgExpand.setOnClickListener {
            imgExpand.rotation = if (imgExpand.rotation == 0f) 180f else 0f
            if (layoutShouldExpand.visibility == View.VISIBLE) {
                layoutShouldExpand.collapse()
            } else {
                layoutShouldExpand.expand()
            }
        }
    }
}