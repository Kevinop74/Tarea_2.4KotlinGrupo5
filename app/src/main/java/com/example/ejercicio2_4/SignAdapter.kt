package com.example.ejercicio2_4

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicio2_4.SignAdapter.SignViewHolder
import com.example.ejercicio2_4.tabla.signaturess

class SignAdapter(private val items: List<signaturess>) : RecyclerView.Adapter<SignViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): SignViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.sing_card, viewGroup, false)
        return SignViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: SignViewHolder, i: Int) {
        val BMP = BitmapFactory.decodeByteArray(items[i].image, 0, items[i].image.size)

        viewHolder.firma.setImageBitmap(BMP)
        viewHolder.descripcion.text = items[i].descripcion
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class SignViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // Campos respectivos de un item
        var firma: ImageView = v.findViewById<View>(R.id.firma) as ImageView
        var id: TextView? = null
        var nombre: TextView? = null
        var fecha: TextView? = null
        var formato: TextView? = null
        var bytes: TextView? = null
        var descripcion: TextView = v.findViewById<View>(R.id.descripcion) as TextView
    }
}
