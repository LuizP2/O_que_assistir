package com.example.form.UI


import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.form.R
import com.example.form.dao.forumDao
import com.example.form.models.forum
import java.math.BigDecimal

class form_forum_Activity :
    AppCompatActivity(R.layout.activity_form_forum) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val submit = findViewById<Button>(R.id.submit_button)
        submit.setOnClickListener {

            val tituloform = findViewById<EditText>(R.id.tituloform)
            val titulo = tituloform.text.toString()

            val descricaoform = findViewById<EditText>(R.id.descricaoform)
            val descricao = descricaoform.text.toString()

            val viewsform = findViewById<EditText>(R.id.viewsform)
            val views = if(viewsform.text.toString().isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(viewsform.text.toString())
            }

            val newForum = forum(
                titulo = titulo,
                descricao = descricao,
                views = views
            )

            val dao = forumDao()
            dao.cadastrar(newForum)

            Log.i("Forum", "onCreate: $newForum")
            Log.i("Forum", "onCreate: ${dao.listar()}")

            finish()
        }

    }


}