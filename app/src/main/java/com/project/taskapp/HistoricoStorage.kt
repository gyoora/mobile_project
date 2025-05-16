package com.project.taskapp

object HistoricoStorage {
    private val historico = mutableListOf<String>()

    fun adicionar(expressao: String) {
        historico.add(0, expressao)
    }

    fun obterTodos(): List<String> = historico

    fun remover(index: Int) {
        if (index in historico.indices) {
            historico.removeAt(index)
        }
    }

    fun limpar() {
        historico.clear()
    }
}
