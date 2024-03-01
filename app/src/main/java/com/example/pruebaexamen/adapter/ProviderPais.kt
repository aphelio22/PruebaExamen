package com.example.pruebaexamen.adapter

import com.example.pruebaexamen.R
import com.example.pruebaexamen.model.Pais

class ProviderPais {
    companion object{
        val listaPais = mutableListOf<Pais>(
            Pais(1,"Albania", R.drawable.b_albania, R.drawable.c_vacia, R.drawable.m_albania,"3.038.594","Tirana", 37.56640275933285 ,-4.7406737719892265, false),
            Pais(2,"Alemania",R.drawable.b_alemania, R.drawable.c_europa,R.drawable.m_alemania,"81.305.856","Berlín", 51.1642292, 10.4541194, true),
            Pais(3,"Austria",R.drawable.b_austria, R.drawable.c_europa,R.drawable.m_austria,"8.219.743","Viena",47.6964719, 13.3457347,true),
        )
    }
}