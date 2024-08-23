package com.example.draggablerecyclerview

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class HandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_handler)

        //Executes continuously with time interval
        val handler = Handler(Looper.getMainLooper())
        val runnable = object: Runnable {
            override fun run() {
                println("handler started on ${Thread.currentThread().name}")
                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)

/*
        //Executes only once
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            println("handler started")
            println("handler started on ${Thread.currentThread().name}")
        }, 1000)
        */

        val thread = Thread {
            Looper.prepare()
            val handler = Handler(Looper.myLooper()!!)
            val runnable = object: Runnable {
                override fun run() {
                    println("handler started on ${Thread.currentThread().name}")
                    handler.postDelayed(this, 1000)
                }
            }
            handler.post(runnable)
            Looper.loop()
        }

        thread.start()

    }
}