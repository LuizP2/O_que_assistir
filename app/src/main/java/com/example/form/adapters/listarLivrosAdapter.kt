package com.example.form.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.form.R
import com.example.form.models.livro
import java.text.SimpleDateFormat

class listarLivrosAdapter(
    private val context: Context,
    livros: List<livro>
): RecyclerView.Adapter<listarLivrosAdapter.Holder>() {
    private val Livros = livros.toMutableList()

    class Holder(view: View):RecyclerView.ViewHolder(view){

        fun vincular(livros: livro){
            val titulo = itemView.findViewById<TextView>(R.id.titulo)
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            val dataPublicacao = itemView.findViewById<TextView>(R.id.data)
            val imagem = itemView.findViewById<ImageView>(R.id.imagem)

            val dataFormatada = formatardata(livros)

            titulo.text = livros.titulo
            descricao.text = livros.descricao
            dataPublicacao.text = dataFormatada
            imagem.setImageURI(livros.imagem)

        }

        private fun formatardata(livros: livro): String {
            val formatador = SimpleDateFormat("HH:mm'h', dd/MM/yyyy")
            val dataFormatada = formatador.format(livros.dataPublicacao)
            return dataFormatada
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): Holder {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.livro_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = Livros.size

    override fun onBindViewHolder(
        holder: Holder,
        position: Int) {
        val livro = Livros[position]
        holder.vincular(livro)
    }

    fun atualizar(livros: List<livro>) {
        this.Livros.clear()
        this.Livros.addAll(livros)
        notifyDataSetChanged()

    }
}