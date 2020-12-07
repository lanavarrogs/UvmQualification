package com.lanavarrog.uvmqualification.adapters

import com.lanavarrog.uvmqualification.model.Materia


interface MateriaListener {
    fun onMateriaClicked(materia: Materia, position: Int)
}