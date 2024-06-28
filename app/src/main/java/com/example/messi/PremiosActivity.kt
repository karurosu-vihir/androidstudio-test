package com.example.messi


import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PremiosActivity : AppCompatActivity() {
    lateinit var baseHelper: BaseDatosHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_premios)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //variables
        val listaPremios = findViewById<ListView>(R.id.listaPremios)
        val btnAtras = findViewById<Button>(R.id.btnAtras)

        //Adapter
        val elmtVista = intArrayOf(R.id.descripcion ,R.id.cantidad, R.id.categoria)

        val columnas = arrayOf(BaseDatosHelper.COLUMNA_DESCRIPCIONPREMIOS, BaseDatosHelper.COLUMNA_CANTIDADPREMIOS, BaseDatosHelper.COLUMNA_CATEGORIAPREMIOS)

        baseHelper=BaseDatosHelper(this)
        val premios=baseHelper.MostrarPremios()

        listaPremios.adapter = SimpleCursorAdapter(this,R.layout.itempremiosganados, premios, columnas ,elmtVista,0)

        //boton salir
        btnAtras.setOnClickListener {
            finish()
        }
    }
}