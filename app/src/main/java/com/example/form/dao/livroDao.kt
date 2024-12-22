package com.example.form.dao

import com.example.form.models.livro

class livroDao {

    fun cadastrar(livro: livro) {
        livros.add(livro)
    }

    fun editar(livro: livro) {
        val index = livros.indexOfFirst { it.titulo == livro.titulo }
        if (index != -1) {
            livros[index] = livro
        }
    }

    fun deletar(livro: livro) {
        livros.remove(livro)
    }

    fun listar(): List<livro> {
        return livros.toList()
    }

    companion object {
        private val livros = mutableListOf<livro>()
    }
}