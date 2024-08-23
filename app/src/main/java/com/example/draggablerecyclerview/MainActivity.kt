package com.example.draggablerecyclerview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections

class MainActivity : AppCompatActivity(), DragHelper {
    private lateinit var recView1: RecyclerView
    private lateinit var recView2: RecyclerView
    private var mAdapter1: MAdapter? = null
    private var mAdapter2: MAdapter? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recView1 = findViewById(R.id.rv1)
        recView2 = findViewById(R.id.rv2)

        val list1 = arrayListOf(
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_box_24,
            R.drawable.baseline_account_balance_24,
        )
        val list2 = arrayListOf(
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_balance_24,
            R.drawable.baseline_account_balance_24,
        )

        mAdapter1 = MAdapter(imageList = list1, onItemRemoved = { pos: Int ->
            /*list2.add(list1[pos])
            list1.removeAt(pos)
            mAdapter1?.notifyItemRemoved(pos)
            mAdapter2?.notifyItemInserted(list2.size - 1)*/
        })
        mAdapter2 = MAdapter(imageList = list2, onItemRemoved = { pos: Int ->
            /*list1.add(list2[pos])
            list2.removeAt(pos)
            mAdapter2?.notifyItemRemoved(pos)
            mAdapter1?.notifyItemInserted(list1.size - 1)*/
        })

        recView1.adapter = mAdapter1
        recView2.adapter = mAdapter2


        val itemTouchHelper = ItemTouchHelper(onDrag(onMove = { fromPos: Int, toPos: Int ->
            Collections.swap(list1, toPos, fromPos)
            mAdapter1?.notifyItemMoved(fromPos, toPos)
        }))

        itemTouchHelper.attachToRecyclerView(recView1)
    }
}