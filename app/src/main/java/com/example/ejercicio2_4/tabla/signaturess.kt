package com.example.ejercicio2_4.tabla

class signaturess {
    @kotlin.jvm.JvmField
    var id: Int? = null
    var image: ByteArray
    var descripcion: String? = null

    constructor()

    constructor(id: Int?, image: ByteArray, descripcion: String?) {
        this.id = id
        this.image = image
        this.descripcion = descripcion
    }
}
