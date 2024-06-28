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
        val VERSION_BASE_DATOS = 18

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
        const val CREAR_INFO_GENERAL = "CREATE TABLE $TABLE_INFO_GENERAL ($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMNA_TITULO TEXT, $CONTENIDO_TABLA TEXT)"
        const val CREAR_GOLES = "CREATE TABLE $TABLE_GOLES($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMNA_EQUIPO TEXT, $COLUMNA_CANTIDADGOLES INTEGER)"
        const val CREAR_PREMIOS = "CREATE TABLE $TABLE_PREMIOS ($COLUMNA_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMNA_DESCRIPCIONPREMIOS TEXT, $COLUMNA_CANTIDADPREMIOS INTEGER, $COLUMNA_CATEGORIAPREMIOS TEXT)"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREAR_INFO_GENERAL)
        db?.execSQL(CREAR_GOLES)
        db?.execSQL(CREAR_PREMIOS)
        estado = true
        Log.d("mens",estado.toString())
    }



    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sqlInfoGeneral = "DROP TABLE IF EXISTS $TABLE_INFO_GENERAL"
        val sqlPremios = "DROP TABLE IF EXISTS $TABLE_PREMIOS"
        val sqlGoles = "DROP TABLE IF EXISTS $TABLE_GOLES"
        db?.execSQL(sqlInfoGeneral)
        db?.execSQL(sqlPremios)
        db?.execSQL(sqlGoles)
        onCreate(db)
    }

    fun insertarInfoGeneral(db: SQLiteDatabase){
        val caracteristicas = listOf(
            ContentValues().apply {
                put(COLUMNA_TITULO, "Nombre")
                put(CONTENIDO_TABLA, "Lionel Andrés Messi Cuccittini")
            },
            ContentValues().apply {
                put(COLUMNA_TITULO, "Fecha de nacimiento")
                put(CONTENIDO_TABLA, "24/06/1987")
            },
            ContentValues().apply {
                put(COLUMNA_TITULO, "Edad")
                put(CONTENIDO_TABLA, "37")
            },
            ContentValues().apply {
                put(COLUMNA_TITULO, "Estatura")
                put(CONTENIDO_TABLA, "1.70 metros")
            },
            ContentValues().apply {
                put(COLUMNA_TITULO, "Lugar de nacimiento")
                put(CONTENIDO_TABLA, "Rosario, Argentina")
            },
            ContentValues().apply {
                put(COLUMNA_TITULO, "Año de su debut como profesional")
                put(CONTENIDO_TABLA, "16/11/2003")
            },
            ContentValues().apply {
                put(COLUMNA_TITULO, "Equipo actual")
                put(CONTENIDO_TABLA, "Inter de Miami")
            },
            ContentValues().apply {
                put(COLUMNA_TITULO, "Equipo preferido")
                put(CONTENIDO_TABLA, "Club Atlético Newell's Old Boys")
            },
            ContentValues().apply {
                put(COLUMNA_TITULO, "Partidos jugados")
                put(CONTENIDO_TABLA, "1066")
            },
            ContentValues().apply {
                put(COLUMNA_TITULO, "Patrocinador")
                put(CONTENIDO_TABLA, "Adidas")
            }
        )
        for(caracteristica in caracteristicas){
            db.insert(TABLE_INFO_GENERAL, null, caracteristica)
        }
    }

    fun insertarPremios(db: SQLiteDatabase){
        val premios = listOf(
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Champions League")
                put(COLUMNA_CANTIDADPREMIOS, 4)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "La Liga")
                put(COLUMNA_CANTIDADPREMIOS, 10)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Copa del Rey")
                put(COLUMNA_CANTIDADPREMIOS, 7)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Mundial de Clubes")
                put(COLUMNA_CANTIDADPREMIOS, 3)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Supercopa de Europa")
                put(COLUMNA_CANTIDADPREMIOS, 3)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Supercopa de España")
                put(COLUMNA_CANTIDADPREMIOS, 8)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Ligue 1")
                put(COLUMNA_CANTIDADPREMIOS, 2)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Trophée des Champions")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Leagues Cup")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Copa América")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Mundial Sub-20")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Medalla Oro Juegos Olímpicos Beijing")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Mundial Fútbol")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Finalissima")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Colectivo")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Balón de Oro")
                put(COLUMNA_CANTIDADPREMIOS, 8)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "FIFA World Player")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Premio The Best")
                put(COLUMNA_CANTIDADPREMIOS, 3)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Bota de Oro")
                put(COLUMNA_CANTIDADPREMIOS, 6)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Premio Laureus")
                put(COLUMNA_CANTIDADPREMIOS, 2)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Pichichi de La Liga")
                put(COLUMNA_CANTIDADPREMIOS, 8)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "MVP La Liga")
                put(COLUMNA_CANTIDADPREMIOS, 9)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Máximo goleador Champions")
                put(COLUMNA_CANTIDADPREMIOS, 6)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Trofeo Bravo")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "FIFPro")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Balón de Oro Muncial")
                put(COLUMNA_CANTIDADPREMIOS, 2)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Mejor Jugador Europa")
                put(COLUMNA_CANTIDADPREMIOS, 2)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Golden Boy")
                put(COLUMNA_CANTIDADPREMIOS, 1)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "MVP Copa América")
                put(COLUMNA_CANTIDADPREMIOS, 2)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            },
            ContentValues().apply {
                put(COLUMNA_DESCRIPCIONPREMIOS, "Onze d'Or")
                put(COLUMNA_CANTIDADPREMIOS, 4)
                put(COLUMNA_CATEGORIAPREMIOS, "Individual")
            }
        )
        for(premio in premios){
            db.insert(TABLE_PREMIOS, null, premio)
        }
    }

    fun insertarGoles(db: SQLiteDatabase){
        val goles = listOf(
            ContentValues().apply {
                put(COLUMNA_EQUIPO, "Barcelona")
                put(COLUMNA_CANTIDADGOLES, 672)
            },
            ContentValues().apply {
                put(COLUMNA_EQUIPO, "Argentina")
                put(COLUMNA_CANTIDADGOLES, 108)
            },
            ContentValues().apply {
                put(COLUMNA_EQUIPO, "PSG")
                put(COLUMNA_CANTIDADGOLES, 32)
            },
            ContentValues().apply {
                put(COLUMNA_EQUIPO, "Inter de Miami")
                put(COLUMNA_CANTIDADGOLES, 25)
            }
        )
        for(gol in goles){
            db.insert(TABLE_GOLES, null, gol)
        }
    }

    fun MostrarInfoGeneral(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_INFO_GENERAL", null)
    }

    fun MostrarPremios():Cursor{
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_PREMIOS", null)
    }

    fun MostrarGoles(): Cursor {
        val db = readableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_GOLES", null)
    }

    fun InsertarTodo(){
        val db=writableDatabase
        if(estado){
            insertarInfoGeneral(db)
            insertarPremios(db)
            insertarGoles(db)
        }
    }

}