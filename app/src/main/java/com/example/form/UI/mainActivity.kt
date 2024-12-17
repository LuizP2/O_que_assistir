package com.example.form.UI

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.form.R
import com.example.form.adapters.listarforumsAdapter
import com.example.form.models.forum

class mainActivity:
    AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val objForum = findViewById<RecyclerView>(R.id.forumObj)

        objForum.adapter = listarforumsAdapter(context = this, forms = listOf(


        ))
        objForum.layoutManager = LinearLayoutManager(this)
    }
}