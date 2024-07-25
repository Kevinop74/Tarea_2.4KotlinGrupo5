package com.example.ejercicio2_4.Transacciones

object Transacciones {
    const val tabla_firmas: String = "tbl_firmas"


    /*CAMPOS*/
    const val id: String = "id"
    const val image: String = "image"
    const val descripcion: String = "descripcion"


    /* tablas - CREATE , DROP */
    const val CreateTableFirmas: String = "CREATE TABLE tbl_firmas" +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "image BLOB, " +
            "descripcion TEXT)"

    const val DropTableFirmas: String = "DROP TABLE IF EXISTS tbl_firmas"


    /* Creacion del nombre de la base de datos */
    const val NameDataBase: String = "dbfirma"
}
