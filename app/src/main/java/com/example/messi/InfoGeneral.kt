package com.example.messi

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InfoGeneral : AppCompatActivity() {
    lateinit var baseHelper: BaseDatosHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_info_general)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        Variables
        val atras = findViewById<Button>(R.id.button)
        val listaInfoGeneral = findViewById<ListView>(R.id.lista)

//        Elemento del adapter
        val elemvista =intArrayOf(R.id.idItem, R.id.titulo, R.id.contenido)

        val columnas = arrayOf(BaseDatosHelper.COLUMNA_ID, BaseDatosHelper.COLUMNA_TITULO, BaseDatosHelper.CONTENIDO_TABLA)

        baseHelper=BaseDatosHelper(this)
        val caracteristicas=baseHelper.MostrarInfoGeneral()

        listaInfoGeneral.adapter = SimpleCursorAdapter(this,R.layout.iteminfogeneral, caracteristicas, columnas ,elemvista,0)

//        Salir
        atras.setOnClickListener {
            finish()
        }
    }
}