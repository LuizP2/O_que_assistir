package com.example.form.UI


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.form.R
import com.example.form.dao.livroDao
import com.example.form.databinding.ActivityFormLivroBinding
import com.example.form.models.livro
import java.util.Date

class form_Livro_Activity :
    AppCompatActivity(R.layout.activity_form_livro) {

        private val dao = livroDao()
        private lateinit var binding: ActivityFormLivroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val submit = binding.submitButton
        submit.setOnClickListener {

            dao.cadastrar(recebeInfoForm())
            
            finish()
        }

    }

    private fun recebeInfoForm(): livro {
        val titulo = binding.tituloform.text.toString()
        val descricao = binding.descricaoform.text.toString()
        val dataPublicacao = Date()

        Log.i("Forum", "Título: $dataPublicacao")

        return livro(
            titulo = titulo,
            descricao = descricao,
            dataPublicacao = dataPublicacao
        )
    }


}