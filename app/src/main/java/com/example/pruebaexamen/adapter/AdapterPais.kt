package com.example.pruebaexamen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaexamen.R
import com.example.pruebaexamen.model.Pais

class AdapterPais(private var paisLista: MutableList<Pais>, private val onClickListener: (Pais) -> Unit): RecyclerView.Adapter<ViewHolderPais>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPais {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderPais(layoutInflater.inflate(R.layout.item_pais_layout, parent, false))
    }

    fun updateList(newList: MutableList<Pais>) {
        val paisDiff = PaisDiffUtil(paisLista, newList)
        val result = DiffUtil.calculateDiff(paisDiff)
        paisLista = newList
        result.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
       return paisLista.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolderPais, position: Int) {
        val item = paisLista[position]
        viewHolder.render(item, onClickListener)
    }
}