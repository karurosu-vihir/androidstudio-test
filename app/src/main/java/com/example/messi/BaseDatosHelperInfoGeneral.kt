package com.example.messi
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BaseDatosHelper (context: Context) : SQLiteOpenHelper(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS){
    companion object{
        val NOMBRE_BASE_DATOS = "InfoGeneral.db"
        val VERSION_BASE_DATOS = 1
        private const val NOMBRE_TABLA = "datosmessi"
        private const val COLUMNA_TITULO = "titulo"
        private const val COLUMNA_ID = "id"
        private const val CONTENIDO_TABLA = "contenido"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE $NOMBRE_TABLA ($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMNA_TITULO TEXT, $CONTENIDO_TABLA TEXT)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS $NOMBRE_TABLA"
        db?.execSQL(sql)
        onCreate(db)
    }

    /*fun insertarDatos(titulo: String, contenido: String){
        val db = writableDatabase
        val datos = ContentValues()
        datos.put(COLUMNA_TITULO, titulo)
        datos.put(CONTENIDO_TABLA, contenido)
    }*/

    /*fun obtenerDatos(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM $NOMBRE_TABLA", null)
    }*/


}