package com.project.taskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AgendarTarefaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendar_tarefa)

        val editTitulo = findViewById<EditText>(R.id.editTextTitulo)
        val editDescricao = findViewById<EditText>(R.id.editTextDescricao)
        val btnAgendar = findViewById<Button>(R.id.buttonAgendar)

        btnAgendar.setOnClickListener {
            val titulo = editTitulo.text.toString()
            val descricao = editDescricao.text.toString()

            val intent = Intent(this, ResumoTarefaActivity::class.java)
            intent.putExtra("TITULO", titulo)
            intent.putExtra("DESCRICAO", descricao)
            startActivity(intent)
        }
    }
}
