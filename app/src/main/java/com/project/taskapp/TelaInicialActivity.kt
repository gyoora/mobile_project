package com.project.taskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TelaInicialActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOME_USUARIO = "NOME_USUARIO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        // 1. Recebe o nome que veio do Login
        val nome = intent.getStringExtra(EXTRA_NOME_USUARIO) ?: ""

        // 2. Atualiza o TextView da saudação
        findViewById<TextView>(R.id.textViewSaudacao).text = "Bem-vindo, $nome!"

        // 3. Configura botões para navegar às próximas telas
        findViewById<Button>(R.id.buttonAgendar).setOnClickListener {
            startActivity(Intent(this, AgendarTarefaActivity::class.java))
        }

        findViewById<Button>(R.id.buttonCalculadora).setOnClickListener {
            startActivity(Intent(this, CalculadoraActivity::class.java))
        }
    }
}
