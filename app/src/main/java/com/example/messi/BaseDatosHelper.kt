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
        private const val TABLA_PREMIOS = "datosmessi"
        private const val COLUMNA_TITULO = "titulo"
        private const val COLUMNA_ID = "id"
        private const val CONTENIDO_TABLA = "contenido"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE $TABLA_PREMIOS ($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMNA_TITULO TEXT, $CONTENIDO_TABLA TEXT)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS $TABLA_PREMIOS"
        db?.execSQL(sql)
        onCreate(db)
    }

    private fun datosMessiGeneral(db: SQLiteDatabase?){
        val values= ContentValues().apply{
            put(COLUMNA_ID, 1)
            put(COLUMNA_TITULO, "Lionel Andrés Messi Cuccittini")
            put(CONTENIDO_TABLA,"Lionel Andrés Messi Cuccittini nació el 24 de junio de 1987 (36 años) en Rosario, " +
                    "Argentina. Es reconocido por muchos como el mejor futbolista y uno de los mejores deportistas de todos los tiempos, ha ganado 44 títulos colectivos y más " +
                    "de 50 títulos individuales en su carrera. Es el jugador con más Balones de Oro y uno de los pocos en ganar " +
                    "una medalla de oro en los juegos olímpicos y un Mundial.")
        }

        if (db != null) {
            db.insert(TABLA_PREMIOS, null, values)
        }

    }


}