package com.example.form.UI

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.form.R
import com.example.form.adapters.listarforumsAdapter
import com.example.form.models.forum

class mainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val objForum = findViewById<RecyclerView>(R.id.forumObj)

        objForum.adapter = listarforumsAdapter(context = this, forms = listOf(
            forum(
                titulo = "Titulo do forum",
                descricao = "Descrição do forum",
                views = 110
            ),
            forum(
                titulo = "Titulo do forum2",
                descricao = "Descrição do forum2",
                views = 120
            ),
            forum(
                titulo = "Titulo do forum3",
                descricao = "Descrição do forum3",
                views = 130
            ),
            forum(
                titulo = "Titulo do forum4",
                descricao = "Descrição do forum4",
                views = 140
            )

        ))
        objForum.layoutManager = LinearLayoutManager(this)
    }
}