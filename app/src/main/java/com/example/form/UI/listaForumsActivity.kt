package com.example.form.UI

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.form.R
import com.example.form.adapters.listarforumsAdapter
import com.example.form.dao.forumDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class listaForumsActivity:
    AppCompatActivity(R.layout.activity_lista_forums) {
        private val dao = forumDao()
        private val adapter = listarforumsAdapter(context = this, forms = dao.listar())

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            configRecyclerView()
            configFAB()
        }

        override fun onResume() {
            super.onResume()
            adapter.atualizar(dao.listar())
        }

    private fun configFAB() {
        val FAB = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        FAB.setOnClickListener {
            abrirFormulario()
        }
    }

    private fun abrirFormulario() {
        val intent = Intent(this, form_forum_Activity::class.java)
        startActivity(intent)
    }

    private fun configRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        recyclerView.adapter = adapter
    }
}
