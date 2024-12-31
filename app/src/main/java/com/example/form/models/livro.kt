package com.example.form.models

import android.net.Uri
import java.util.Date

data class livro (
    val titulo: String,
    val descricao: String,
    val dataPublicacao: Date = Date(),
    val imagem: Uri? = null
)
