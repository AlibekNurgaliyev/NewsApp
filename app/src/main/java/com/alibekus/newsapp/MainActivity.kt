package com.alibekus.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val exampleList = generateRandomList(100)

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.adapter = RecyclerViewAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    }

    private fun generateRandomList(size: Int): List<RecyclerViewItem> {
        val list = ArrayList<RecyclerViewItem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_baseline_adb_24
                1 -> R.drawable.ic_baseline_architecture_24
                else -> R.drawable.ic_baseline_audiotrack_24
            }
            val item = RecyclerViewItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}