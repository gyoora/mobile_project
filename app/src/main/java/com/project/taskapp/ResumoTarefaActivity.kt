package com.project.taskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumoTarefaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo_tarefa)

        val titulo = intent.getStringExtra("TITULO")
        val descricao = intent.getStringExtra("DESCRICAO")

        findViewById<TextView>(R.id.textTitulo).text = "Título: $titulo"
        findViewById<TextView>(R.id.textDescricao).text = "Descrição: $descricao"

        findViewById<Button>(R.id.buttonVoltar).setOnClickListener {
            startActivity(Intent(this, TelaInicialActivity::class.java))
            finish()
        }
    }
}
