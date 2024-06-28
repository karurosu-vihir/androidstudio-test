package com.example.messi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var baseHelper: BaseDatosHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        baseHelper=BaseDatosHelper(this)
        baseHelper.InsertarTodo()

        val informacionpersonal: Button = findViewById(R.id.btnInfoPersonal)
        val premios: Button = findViewById(R.id.btnpremios)
        val goles: Button = findViewById(R.id.btngoles)

        informacionpersonal.setOnClickListener {
            val intent = Intent(this, InfoGeneral::class.java)
            startActivity(intent)
        }
        premios.setOnClickListener {
            val intent = Intent(this, PremiosActivity::class.java)
            startActivity(intent)
        }
        goles.setOnClickListener {
            val intent = Intent(this, GolesMarcados::class.java)
            startActivity(intent)
        }
    }
}