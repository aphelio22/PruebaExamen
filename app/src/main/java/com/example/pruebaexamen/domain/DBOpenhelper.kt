package com.example.pruebaexamen.domain

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.pruebaexamen.adapter.ProviderPais
import java.lang.Exception

class DBOpenHelper private constructor(context: Context?) :
    SQLiteOpenHelper(context, PaisContract.NOMBRE_BD, null, PaisContract.VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(
                "CREATE TABLE ${PaisContract.Companion.Entrada.NOMBRE_TABLA}"
                        + "(${PaisContract.Companion.Entrada.COLUMNA_ID} INTEGER NOT NULL"
                        + ",${PaisContract.Companion.Entrada.COLUMNA_NOMBRE} NVARCHAR(20) NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_IMAGEN} INTEGER" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_IMAGEN_UE} INTEGER" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_MAPA} INTEGER" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_HABITANTES} NVARCHAR(20) NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_CAPITAL} NVARCHAR(20) NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_LATITUD} REAL NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMNA_LONGITUD} REAL NOT NULL" +
                        ",${PaisContract.Companion.Entrada.COLUMN_PERTENECE_UE} INTEGER NOT NULL);")

            inicializarBBDD(sqLiteDatabase)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ${PaisContract.Companion.Entrada.NOMBRE_TABLA};")
        onCreate(sqLiteDatabase)
    }

    private fun inicializarBBDD(db: SQLiteDatabase) {
        val lista = ProviderPais.listaPais
        for (pais in lista) {
            //Importante para cargar o no países de la UE
            val valorBooleano = if (pais.UE) 1 else 0
            db.execSQL(
                "INSERT INTO ${PaisContract.Companion.Entrada.NOMBRE_TABLA}(" +
                        "${PaisContract.Companion.Entrada.COLUMNA_ID}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_NOMBRE}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_IMAGEN}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_IMAGEN_UE}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_MAPA}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_HABITANTES}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_CAPITAL}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_LATITUD}," +
                        "${PaisContract.Companion.Entrada.COLUMNA_LONGITUD}," +
                        "${PaisContract.Companion.Entrada.COLUMN_PERTENECE_UE})" +
                        " VALUES (${pais.id},'${pais.nombre}',${pais.imagenPais},${pais.imagenUE},${pais.mapaPais},'${pais.habitantes}','${pais.capital}',${pais.latitud},${pais.longitud},$valorBooleano);"
            )
        }
    }

    companion object {
        private var dbOpen: DBOpenHelper? = null
        fun getInstance(context: Context?): DBOpenHelper? {
            if (dbOpen == null) dbOpen = DBOpenHelper(context)
            return dbOpen
        }
    }
}