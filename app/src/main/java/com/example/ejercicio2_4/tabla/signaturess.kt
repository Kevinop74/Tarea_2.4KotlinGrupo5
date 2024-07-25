package com.example.ejercicio2_4.tabla

class Signatures {
    var id: Int? = null
    var image: ByteArray = ByteArray(0) // Inicialización con un array vacío
    var descripcion: String? = null

    constructor()

    constructor(id: Int?, image: ByteArray, descripcion: String?) {
        this.id = id
        this.image = image
        this.descripcion = descripcion
    }}