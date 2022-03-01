package br.com.fiap.sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Saudacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val txvSaudacao = findViewById<TextView>(R.id.txvSaudacao)

        val saudacaoSharedPref = this.getSharedPreferences("saudacao",Context.MODE_PRIVATE)

        val nome = saudacaoSharedPref.getString("nome", "Usuário(a)")
        val tratamento = saudacaoSharedPref.getString("tratamento", "Sr(a)")

        if (tratamento.equals("N/A")) {
            txvSaudacao.text = nome;
        } else {
            txvSaudacao.text = tratamento + " " + nome
        }
    }
}