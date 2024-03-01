package com.example.pruebaexamen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pruebaexamen.model.Pais

class PaisDiffUtil(private val oldList: MutableList<Pais>,
    private val newList: MutableList<Pais>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}