package com.example.pruebaexamen.domain

import android.provider.BaseColumns

class PaisContract {
    companion object {
        const val NOMBRE_BD = "paisesEuropa"
        const val VERSION = 1
        class Entrada : BaseColumns {
            companion object {
                const val NOMBRE_TABLA = "paises"
                const val COLUMNA_ID = "id"
                const val COLUMNA_NOMBRE = "nombre"
                const val COLUMNA_IMAGEN = "imagen"
                const val COLUMNA_IMAGEN_UE = "imagen_ue"
                const val COLUMNA_MAPA = "imagen_mapa"
                const val COLUMNA_HABITANTES = "habitantes"
                const val COLUMNA_CAPITAL = "capital"
                const val COLUMNA_LATITUD = "latitud"
                const val COLUMNA_LONGITUD = "longitud"
                const val COLUMN_PERTENECE_UE = "pertenece_ue"
            }
        }
    }
}