package com.example.ejercicio2_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2_4.Transacciones.Transacciones

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        recycler!!.layoutManager = LinearLayoutManager(this)

    }

        val conexion = SQLiteConexion(this, Transacciones.NameDataBase, null, 1)
        val db = conexion.readableDatabase


            while (cursor.moveToNext()) {

            }

            cursor.close()
        }

    }
}
