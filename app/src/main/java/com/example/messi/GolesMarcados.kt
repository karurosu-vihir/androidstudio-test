package com.example.messi

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GolesMarcados : AppCompatActivity() {
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
        val elmtVista = intArrayOf(R.id.idItem, R.id.goles, R.id.equipo, R.id.año)

        //boton salir
        btnAtras.setOnClickListener {
            finish()
        }
    }
}