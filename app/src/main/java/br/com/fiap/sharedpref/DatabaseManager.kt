package br.com.fiap.sharedpref

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseManager(context: Context, name: String) : SQLiteOpenHelper(context, name,null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val criarTabela = "CREATE TABLE tbl_saudacao (" +
                "id_saudacao INT NOT NULL," +
                "nome VARCHAR(20)," +
                "tratamento VARCHAR(20)," +
                "PRIMARY KEY (id_saudacao)" +
                ");"
        db!!.execSQL(criarTabela)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS tbl_saudacao")
        onCreate(db)
    }

    fun insereSaudacao(id: Int, nome: String, tratamento : String){
        var db = this.writableDatabase

        var cv = ContentValues()
        cv.put("id_saudacao",id)
        cv.put("nome", nome)
        cv.put("tratamento",tratamento)

        db.insert("tbl_saudacao", "id_saudacao", cv)
    }

    fun listaSaudacao() : Cursor {
        var db = this.readableDatabase
        var cur = db.rawQuery("SELECT nome, tratamento FROM tbl_saudacao", null)
        return cur
    }

    fun removeSaudacao(){
        var db = this.writableDatabase
        db.delete("tbl_saudacao", "id_saudacao=1",null)
    }
}