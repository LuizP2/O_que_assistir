package com.example.form.UI

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.form.R
import com.example.form.adapters.listarLivrosAdapter
import com.example.form.dao.livroDao
import com.example.form.databinding.ActivityListaLivrosBinding

class listaLivrosActivity:
    AppCompatActivity(R.layout.activity_lista_livros) {
        private val dao = livroDao()
        private val adapter = listarLivrosAdapter(context = this, livros = dao.listar())
        private val binding by lazy { ActivityListaLivrosBinding.inflate(layoutInflater)}

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(binding.root)
            configRecyclerView()
            configFAB()
        }

        override fun onResume() {
            super.onResume()
            adapter.atualizar(dao.listar())
        }

    private fun configFAB() {
        val FAB = binding.floatingActionButton
        FAB.setOnClickListener {
            abrirFormulario()
        }
    }

    private fun abrirFormulario() {
        val intent = Intent(this, form_Livro_Activity::class.java)
        startActivity(intent)
    }

    private fun configRecyclerView(){
        val recyclerView = binding.RecyclerView
        recyclerView.adapter = adapter
    }
}
