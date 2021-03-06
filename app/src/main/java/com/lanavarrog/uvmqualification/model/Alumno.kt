package com.lanavarrog.uvmqualification.model

class Alumno {
    private var matricula: String = ""
    private var email: String = ""
    private var name: String = ""
    private var age: Int = 0
    private var semestre: String = ""
    private var carrera: String = ""
    private lateinit var listMateria: ArrayList<Materia>

    constructor(matricula: String,email: String ){
        this.matricula = matricula
        this.email = email
    }

    fun getMatricula():String {
        return this.matricula
    }

}