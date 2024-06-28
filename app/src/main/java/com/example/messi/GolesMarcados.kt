package com.example.messi

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GolesMarcados : AppCompatActivity() {
    lateinit var baseHelper: BaseDatosHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_goles_marcados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //variables
        val listaGoles = findViewById<ListView>(R.id.listaGoles)
        val btnAtras = findViewById<Button>(R.id.btnAtras)

        //Adapter
        val elmtVista = intArrayOf(R.id.equipo, R.id.goles)

        val columnas = arrayOf(BaseDatosHelper.COLUMNA_EQUIPO, BaseDatosHelper.COLUMNA_CANTIDADGOLES)

        baseHelper=BaseDatosHelper(this)
        val goles=baseHelper.MostrarGoles()

        listaGoles.adapter = SimpleCursorAdapter(this,R.layout.itemgolesmarcados, goles, columnas ,elmtVista,0)

        //boton salir
        btnAtras.setOnClickListener {
            finish()
        }
    }
}