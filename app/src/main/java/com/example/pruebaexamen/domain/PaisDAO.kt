package com.example.pruebaexamen.domain

import android.content.Context
import android.database.Cursor
import com.example.pruebaexamen.model.Pais

class PaisDAO {
    fun cargarLista(context: Context?): MutableList<Pais> {
        lateinit var res: MutableList<Pais>
        lateinit var c: Cursor
        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM paises;"
            c = db.rawQuery(sql, null)
            res = mutableListOf()

            while (c.moveToNext()) {
                val nueva = Pais(
                    c.getInt(0),
                    c.getString(1),
                    c.getInt(2),
                    c.getInt(3),
                    c.getInt(4),
                    c.getString(5),
                    c.getString(6),
                    c.getDouble(7),
                    c.getDouble(8),
                    c.getInt(9) == 1 //Siempre debe ser '== 1'
                )
                res.add(nueva)
            }
        } finally {
            c.close()
        }
        return res
    }

    fun cargarUE(context: Context?): MutableList<Pais> {
        lateinit var res: MutableList<Pais>
        lateinit var c: Cursor
        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM paises WHERE pertenece_ue = 1"
            c = db.rawQuery(sql, null)
            res = mutableListOf()

            while (c.moveToNext()) {
                val nueva = Pais(
                    c.getInt(0),
                    c.getString(1),
                    c.getInt(2),
                    c.getInt(3),
                    c.getInt(4),
                    c.getString(5),
                    c.getString(6),
                    c.getDouble(7),
                    c.getDouble(8),
                    c.getInt(9) == 1 //Siempre debe ser '== 1'
                )
                res.add(nueva)
            }
        } finally {
            c.close()
        }
        return res
    }

    fun cargarNOUE(context: Context?): MutableList<Pais> {
        lateinit var res: MutableList<Pais>
        lateinit var c: Cursor
        try {
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM paises WHERE pertenece_ue = 0;"
            c = db.rawQuery(sql, null)
            res = mutableListOf()

            while (c.moveToNext()) {
                val nueva = Pais(
                    c.getInt(0),
                    c.getString(1),
                    c.getInt(2),
                    c.getInt(3),
                    c.getInt(4),
                    c.getString(5),
                    c.getString(6),
                    c.getDouble(7),
                    c.getDouble(8),
                    c.getInt(9) == 1 //Siempre debe ser '== 1'
                )
                res.add(nueva)
            }
        } finally {
            c.close()
        }
        return res
    }
}