package com.project.taskapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class HistoricoActivity : AppCompatActivity() {
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historico)

        val lista = findViewById<ListView>(R.id.listViewHistorico)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, HistoricoStorage.obterTodos())
        lista.adapter = adapter

        lista.setOnItemClickListener { _, _, position, _ ->
            AlertDialog.Builder(this)
                .setTitle("Remover item")
                .setMessage("Deseja remover esta operação?")
                .setPositiveButton("Sim") { _, _ ->
                    HistoricoStorage.remover(position)
                    adapter.clear()
                    adapter.addAll(HistoricoStorage.obterTodos())
                    adapter.notifyDataSetChanged()
                }
                .setNegativeButton("Cancelar", null)
                .show()
        }

        findViewById<Button>(R.id.buttonVoltarCalculadora).setOnClickListener {
            finish()
        }
    }
}
