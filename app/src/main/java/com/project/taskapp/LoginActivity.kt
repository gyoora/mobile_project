package com.project.taskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NOME_USUARIO = "NOME_USUARIO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)


        val editTextNome = findViewById<EditText>(R.id.editTextNome)
        val buttonEntrar = findViewById<Button>(R.id.buttonEntrar)

        buttonEntrar.setOnClickListener {
            val nomeUsuario = editTextNome.text.toString().trim()
            if (nomeUsuario.isNotEmpty()) {

                val intent = Intent(this, TelaInicialActivity::class.java).apply {
                    putExtra(EXTRA_NOME_USUARIO, nomeUsuario)
                }
                startActivity(intent)

                finish()
            } else {

                Toast.makeText(
                    this,
                    getString(R.string.hint_nome),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
