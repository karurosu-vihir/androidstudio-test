package com.example.messi

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InfoGeneral : AppCompatActivity() {
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
        val lista = findViewById<ListView>(R.id.lista)

//        Elemento del adapter
        val elemvista =intArrayOf(R.id.idItem, R.id.titulo, R.id.contenido)

//        Salir
        atras.setOnClickListener {
            finish()
        }
    }
}