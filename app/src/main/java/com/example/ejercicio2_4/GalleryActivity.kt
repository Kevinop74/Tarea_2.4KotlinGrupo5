package com.example.ejercicio2_4

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2_4.Transacciones.Transacciones
import com.example.ejercicio2_4.tabla.signaturess

class GalleryActivity : AppCompatActivity() {
    var recycler: RecyclerView? = null

    var galeria: ArrayList<signaturess>? = null
    var items: MutableList<signaturess>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        galeria = ArrayList()

        GetListGallery()

        recycler = findViewById<View>(R.id.reciclador) as RecyclerView

        recycler!!.layoutManager = LinearLayoutManager(this)

        val adapter = SignAdapter(items)
        recycler!!.adapter = adapter
    }

    private fun GetListGallery() {
        val conexion = SQLiteConexion(this, Transacciones.NameDataBase, null, 1)
        val db = conexion.readableDatabase
        var Items: signaturess? = null
        galeria = ArrayList()

        val cursor = db.rawQuery("SELECT * FROM " + Transacciones.tabla_firmas, null)

        while (cursor.moveToNext()) {
            Items = signaturess()
            Items.setId(cursor.getInt(0))
            Items.image = cursor.getBlob(1)
            Items.descripcion = cursor.getString(2)

            galeria!!.add(Items)
        }

        cursor.close()
        GalleryList()
    }

    private fun GalleryList() {
        items = ArrayList()

        for (i in galeria!!.indices) {
            items.add(
                signaturess(
                    galeria!![i].getId(),
                    galeria!![i].image,
                    galeria!![i].descripcion
                )
            )
        }
    }
}
