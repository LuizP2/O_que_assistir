package com.example.form.UI


import android.content.Intent
import android.content.Intent.ACTION_PICK
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.form.R
import com.example.form.dao.livroDao
import com.example.form.databinding.ActivityFormLivroBinding
import com.example.form.models.livro
import java.util.Date
import android.Manifest
import android.net.Uri

class form_Livro_Activity :
    AppCompatActivity(R.layout.activity_form_livro) {

        private val dao = livroDao()
        private lateinit var binding: ActivityFormLivroBinding
        private val REQUEST_CODE = 1
        private var imageURI: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val submit = binding.submitButton
        val imageButton = binding.imageButton

        cadastrarImagem(imageButton)

        submit.setOnClickListener {

            dao.cadastrar(recebeInfoForm())
            
            finish()

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && data != null) {
            val imageUri = data.data
            imageURI = imageUri
            val imageView = findViewById<ImageView>(R.id.imagem_Livro)
            imageView.setImageURI(imageUri)
        }
    }

    private fun cadastrarImagem(imageButton: Button) {
        imageButton.setOnClickListener {
            solicitarPermissao()
            val image = Intent(ACTION_PICK)
            image.type = "image/*"
            startActivityForResult(image, REQUEST_CODE)
        }
    }

    private fun solicitarPermissao() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }
    }

    private fun recebeInfoForm(): livro {
        val titulo = binding.tituloform.text.toString()
        val descricao = binding.descricaoform.text.toString()
        val dataPublicacao = Date()
        val imagem = imageURI

        Log.i("Forum", "Título: $dataPublicacao")

        return livro(
            titulo = titulo,
            descricao = descricao,
            dataPublicacao = dataPublicacao,
            imagem = imagem
        )
    }


}