package com.example.form.dao

import com.example.form.models.forum

class forumDao {

    fun cadastrar(forum: forum) {
        forums.add(forum)
    }

    fun editar(forum: forum) {
        val index = forums.indexOfFirst { it.titulo == forum.titulo }
        if (index != -1) {
            forums[index] = forum
        }
    }

    fun deletar(forum: forum) {
        forums.remove(forum)
    }

    fun listar(): List<forum> {
        return forums.toList()
    }

    companion object {
        private val forums = mutableListOf<forum>()
    }
}