package com.example.pruebaexamen.adapter

import android.view.View
import android.view.View.OnClickListener
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pruebaexamen.databinding.ItemPaisLayoutBinding
import com.example.pruebaexamen.model.Pais

class ViewHolderPais(view: View): ViewHolder(view) {
    val binding = ItemPaisLayoutBinding.bind(view)
    private lateinit var pais: Pais

    fun render(item: Pais, onClickListener: (Pais) -> Unit) {
        binding.ivUE.setImageResource(item.imagenUE)
        binding.ivPaisEuropa.setImageResource(item.imagenPais)
        binding.tvPais.text = item.nombre
        itemView.setOnClickListener {
            onClickListener(item)
        }
        pais = item
    }
}