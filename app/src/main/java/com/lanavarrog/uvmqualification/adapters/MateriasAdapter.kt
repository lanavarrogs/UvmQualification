package com.lanavarrog.uvmqualification.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.lanavarrog.uvmqualification.R
import com.lanavarrog.uvmqualification.model.Materia


class MateriasAdapter(val materiaListener: MateriaListener): RecyclerView.Adapter<MateriasAdapter.ViewHolder>() {

    var listMateria = ArrayList<Materia>()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvNombre = itemView.findViewById<TextView>(R.id.tvItemMateriaName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule,parent,false))

    override fun onBindViewHolder(holder: MateriasAdapter.ViewHolder, position: Int) {
        val materia = listMateria[position] as Materia
        holder.tvNombre.text = "Sistemas Operativos"
    }

    override fun getItemCount() = listMateria.size

    fun updateData(data: List<Materia>){

    }
}