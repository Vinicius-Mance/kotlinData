package br.com.fiap.sharedpref

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnExibir = findViewById<Button>(R.id.btnExibir)
        val txtNome = findViewById<EditText>(R.id.txtNome)
        val listTratamento = findViewById<Spinner>(R.id.listTratamento)

        btnSalvar.setOnClickListener{
          /*  val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
            val editor = saudacaoPersistencia.edit()

            editor.putString("nome",txtNome.editableText.toString())
            editor.putString("tratamento", listTratamento.selectedItem.toString())
            editor.apply()


            */
            Toast.makeText(this, "Saudação gravada", Toast.LENGTH_SHORT).show()

            val dados = txtNome.editableText.toString() + ":" + listTratamento.selectedItem.toString()
            gravarDadoArquivo("saudacao", dados)

        }

        btnExibir.setOnClickListener{
            val link = Intent(this,Saudacao::class.java)
            startActivity(link)
        }
    }

    fun gravarDadoArquivo(fileName : String, data : String) {

        try {
            val arquivo = openFileOutput(fileName,Context.MODE_PRIVATE)

            arquivo.write(data.toByteArray())
            arquivo.close()

        } catch (e: FileNotFoundException) {
            Log.i("gravaDadoArquivo", "Fudeu baiah, roubaram o arquivo menó!")
        } catch (e: IOException) {
            Log.i("gravaDadoArquivo", "mano... o bagulho tá sinistro kkkkk EXORCISA!")
        }

    }
}