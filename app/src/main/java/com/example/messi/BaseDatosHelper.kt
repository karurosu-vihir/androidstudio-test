package com.example.messi
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class BaseDatosHelper (context: Context) : SQLiteOpenHelper(context, NOMBRE_BASE_DATOS, null, VERSION_BASE_DATOS){
    var estado : Boolean = false

    companion object{
        val NOMBRE_BASE_DATOS = "Messi.db"
        val VERSION_BASE_DATOS = 4

        //Nombre de la base de datos
        private const val DATABASE_NAME = "MessiBirthday.db"
        private const val DATABASE_VERSION = 3

        //Nombre de las tablas
        private const val TABLE_INFO_GENERAL = "InfoGeneral"
        private const val TABLE_PREMIOS = "Premios"
        private const val TABLE_GOLES = "Goles"


        //Campos comunes
        const val COLUMNA_ID = "_id"


        // Campos de InfoGeneral
        const val COLUMNA_TITULO = "titulo"
        const val CONTENIDO_TABLA = "contenido"

        //Campos de la tabla Premios
        const val COLUMNA_DESCRIPCIONPREMIOS = "descripcionPremio"
        const val COLUMNA_CANTIDADPREMIOS = "cantidadPremios"
        const val COLUMNA_CATEGORIAPREMIOS = "categoriaPremio"

        //Campos de la tabla Goles
        const val COLUMNA_EQUIPO = "equipo"
        const val COLUMNA_CANTIDADGOLES = "cantidadGoles"

        //Campos de la tabla InfoGeneral
        const val COLUMNA_NOMBRECOMPLETO= "nombreCompleto"
        const val CREAR_INFO_GENERAL = "CREATE TABLE $TABLE_INFO_GENERAL ($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMNA_TITULO TEXT, $CONTENIDO_TABLA TEXT)"
        const val CREAR_GOLES = ""
        const val CREAR_PREMIOS = ""
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREAR_INFO_GENERAL)
        estado = true
        Log.d("mens",estado.toString())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS $TABLE_INFO_GENERAL"
        db?.execSQL(sql)
        onCreate(db)
    }



    fun insertarDatos(titulo: String, contenido: String){
        Log.d("mens",estado.toString())
        if(estado){
            Log.d("mens","insertar")
            Log.d("mens",estado.toString())
            val db = writableDatabase
            val valores = ContentValues()
            valores.put(COLUMNA_TITULO, titulo)
            valores.put(CONTENIDO_TABLA, contenido)
            db.insert(TABLE_INFO_GENERAL, null, valores)
        }
    }

    fun obtenerDatos(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_INFO_GENERAL", null)
    }


}