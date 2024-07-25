package com.example.ejercicio2_4

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.CursorFactory
import android.database.sqlite.SQLiteOpenHelper
import com.example.ejercicio2_4.Transacciones.Transacciones

class SQLiteConexion(context: Context?, bddname: String?, factory: CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, bddname, factory, version) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(Transacciones.CreateTableFirmas)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(Transacciones.DropTableFirmas)
        onCreate(db)
    }
}
