package com.project.taskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        val input1 = findViewById<EditText>(R.id.editTextNumero1)
        val input2 = findViewById<EditText>(R.id.editTextNumero2)
        val resultado = findViewById<TextView>(R.id.textResultado)

        fun calcular(operador: String) {
            val n1 = input1.text.toString().toDoubleOrNull()
            val n2 = input2.text.toString().toDoubleOrNull()

            if (n1 == null || n2 == null) {
                Toast.makeText(this, "Insira dois números válidos", Toast.LENGTH_SHORT).show()
                return
            }

            val res = when (operador) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                "*" -> n1 * n2
                "/" -> if (n2 != 0.0) n1 / n2 else {
                    Toast.makeText(this, "Divisão por zero não é permitida", Toast.LENGTH_SHORT).show()
                    return
                }
                else -> 0.0
            }

            val expressao = "$n1 $operador $n2 = $res"
            resultado.text = expressao
            HistoricoStorage.adicionar(expressao)
        }

        findViewById<Button>(R.id.buttonSomar).setOnClickListener { calcular("+") }
        findViewById<Button>(R.id.buttonSubtrair).setOnClickListener { calcular("-") }
        findViewById<Button>(R.id.buttonMultiplicar).setOnClickListener { calcular("*") }
        findViewById<Button>(R.id.buttonDividir).setOnClickListener { calcular("/") }

        findViewById<Button>(R.id.buttonVerHistorico).setOnClickListener {
            startActivity(Intent(this, HistoricoActivity::class.java))
        }
    }
}
