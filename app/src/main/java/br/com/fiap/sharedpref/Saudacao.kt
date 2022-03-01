package br.com.fiap.sharedpref

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.io.FileNotFoundException
import java.io.IOException
import java.nio.charset.Charset
import java.util.*
import kotlin.text.Charsets.UTF_8

class Saudacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudacao)

        val txvSaudacao = findViewById<TextView>(R.id.txvSaudacao)

        val db = DatabaseManager(this,"saudacoes")

        val cursor = db.listaSaudacao()

        var nome = ""
        var tratamento = ""

        if (cursor.count > 0) {
            cursor.moveToFirst()
            nome = cursor.getString(cursor.getColumnIndex("nome"))
            tratamento = cursor.getString(cursor.getColumnIndex("tratamento"))
        }

        if (tratamento.equals("N/A")) {
            txvSaudacao.text = nome
        } else {
            txvSaudacao.text = tratamento + " " + nome
        }

       /* val saudacaoSharedPref = this.getSharedPreferences("saudacao",Context.MODE_PRIVATE)

        val nome = saudacaoSharedPref.getString("nome", "Usuário(a)")
        val tratamento = saudacaoSharedPref.getString("tratamento", "Sr(a)")

        if (tratamento.equals("N/A")) {
            txvSaudacao.text = nome;
        } else {
            txvSaudacao.text = tratamento + " " + nome
        } */

       /* val data = recuperaDadoArquivo("saudacao")

        val tokenizer = StringTokenizer(data, ":")
        val nome = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "sem nome"
        val tratamento = if (tokenizer.hasMoreTokens()) tokenizer.nextToken() else "sem tratamento"

        if (tratamento.equals("N/A")) {
            txvSaudacao.text = nome
        } else {
            txvSaudacao.text = tratamento + " " + nome
        }
    }

   fun recuperaDadoArquivo(fileName : String) : String {

       try {
           val arquivo = openFileInput(fileName)
           val dados = arquivo.readBytes()

           arquivo.close()

           return dados.toString(Charset.defaultCharset())

       } catch (e: FileNotFoundException) {
           Log.i("recuperaDadoArquivo", "Fudeu baiah, roubaram o arquivo menó!")
           return ""
       } catch (e: IOException) {
           Log.i("recuperaDadoArquivo", "mano... o bagulho tá sinistro kkkkk EXORCISA!")
           return ""
       }

        */
   }

}