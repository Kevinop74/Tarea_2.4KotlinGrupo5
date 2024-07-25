package com.example.ejercicio2_4

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio2_4.Transacciones.Transacciones
import java.io.ByteArrayOutputStream

class ActivityFirma : AppCompatActivity() {
    var descripcion: EditText? = null
    var btn_guardar: Button? = null
    var btn_galeria: Button? = null
    var view: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firma)

        descripcion = findViewById<View>(R.id.txtdescripcion) as EditText
        view = findViewById(R.id.viewfirma) as View

        btn_guardar = findViewById<View>(R.id.btnguardar) as Button
        btn_guardar!!.setOnClickListener { guardarfirma() }

        btn_galeria = findViewById<View>(R.id.btngaleria) as Button
        btn_galeria!!.setOnClickListener {
            val intent = Intent(applicationContext, GalleryActivity::class.java)
            startActivity(intent)
        }
    }

    fun guardarfirma() {
        val conexion = SQLiteConexion(this, Transacciones.NameDataBase, null, 1)
        val db = conexion.writableDatabase

        try {
            val descripcionText = descripcion!!.text.toString()

            // Validar que haya una descripción antes de guardar
            if (descripcionText.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Por favor, ingresa una descripción antes de guardar",
                    Toast.LENGTH_LONG
                ).show()
                return  // Salir del método si no hay descripción
            }

            val valores = ContentValues()

            valores.put(Transacciones.image, Viewfirma(view))
            valores.put(Transacciones.descripcion, descripcionText)

            val resultado = db.insert(Transacciones.tabla_firmas, Transacciones.id, valores)

            Toast.makeText(applicationContext, "FIRMA REGISTRADA: $resultado", Toast.LENGTH_LONG)
                .show()
            descripcion!!.setText("")
            view!!.isDrawingCacheEnabled = false
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun ClearScreen() {
        descripcion!!.setText("")
        view!!.isDrawingCacheEnabled = false
    }

    companion object {
        fun Viewfirma(view5: View?): ByteArray {
            view5!!.isDrawingCacheEnabled = true
            val bitmap = view5.drawingCache
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream)

            val byteArray = stream.toByteArray()
            return byteArray
        }
    }
}
