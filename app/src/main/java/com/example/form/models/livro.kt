package com.example.form.models

import java.util.Date

data class livro (
    val titulo: String,
    val descricao: String,
    val dataPublicacao: Date = Date()
)
