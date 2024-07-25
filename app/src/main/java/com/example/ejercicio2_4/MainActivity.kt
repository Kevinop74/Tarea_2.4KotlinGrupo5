package com.example.ejercicio2_4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio2_4.ActivityFirma

class MainActivity : AppCompatActivity() {
    var btnIngresar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIngresar = findViewById<View>(R.id.btnIngresar) as Button

        btnIngresar!!.setOnClickListener {
            val prueba = Intent(applicationContext, ActivityFirma::class.java)
            startActivity(prueba)
        }
    }
}