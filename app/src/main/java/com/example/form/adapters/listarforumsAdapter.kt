package com.example.form.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.form.R
import com.example.form.models.forum

class listarforumsAdapter(
    private val context: Context,
    private val forms: List<forum>
): RecyclerView.Adapter<listarforumsAdapter.Holder>() {
    class Holder(view: View):RecyclerView.ViewHolder(view){

        fun vincular(forums: forum){
            val titulo = itemView.findViewById<TextView>(R.id.titulo)
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            val views = itemView.findViewById<TextView>(R.id.views)

            titulo.text = forums.titulo
            descricao.text = forums.descricao
            views.text = forums.views.toString()

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): Holder {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.forum_item, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int = forms.size

    override fun onBindViewHolder(
        holder: Holder,
        position: Int) {
        val Forum = forms[position]
        holder.vincular(Forum)
    }
}