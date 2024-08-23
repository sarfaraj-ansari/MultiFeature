package com.example.draggablerecyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExpandableRecViewActivity : AppCompatActivity() {
    private lateinit var recView1: RecyclerView
    private lateinit var button: Button
    var isExpanded: Boolean = false

    //2nd
    private lateinit var imgExpand: ImageView
    private lateinit var layoutShouldExpand: LinearLayout
    private lateinit var recView2: RecyclerView

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expandable_rec_view)

        recView1 = findViewById(R.id.rv11111)
        button = findViewById(R.id.button)

        //2nd
        imgExpand = findViewById(R.id.ivExpandCollapse)
        layoutShouldExpand = findViewById(R.id.layoutExpandable)
        recView2 = findViewById(R.id.rv222222)


        val list1 = arrayListOf(
            R.drawable.baseline_assist_walker_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_box_24,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_assist_walker_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_box_24,
        )

        var list2 = arrayListOf(
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_assist_walker_24,
            R.drawable.collapse_expand
        )

        val dummyList = arrayListOf(
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_assist_walker_24,
            R.drawable.collapse_expand
        )

        val manager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recView1.layoutManager = manager
        val animator = CustomItemAnimator(this)
        //recView1.itemAnimator = animator
        val customAdapter = CustomAdapter(list2)
        recView1.adapter = customAdapter


        button.setOnClickListener {

            if(isExpanded) {
                list2.clear()
                list2.addAll(dummyList)
                customAdapter.items = list2
                customAdapter.notifyDataSetChanged()
            } else {
                list2.addAll(list1)
                customAdapter.notifyItemInserted(dummyList.size)
            }

            isExpanded = !isExpanded

        }






        //2nd
        imgExpand.setOnClickListener {
            imgExpand.rotation = if (imgExpand.rotation == 0f) 180f else 0f
            if (layoutShouldExpand.visibility == View.VISIBLE) {
                layoutShouldExpand.collapse()
            } else {
                layoutShouldExpand.expand()
            }
        }

        val list222 = arrayListOf(
            R.drawable.baseline_assist_walker_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_box_24,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.collapse_expand,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_assist_walker_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_box_24,
        )

        val customAdapter2 = CustomAdapter(list222)
        recView2.adapter = customAdapter2

    }
}