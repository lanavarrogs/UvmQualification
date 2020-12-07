package com.lanavarrog.uvmqualification.services

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.lanavarrog.uvmqualification.model.Materia
import com.lanavarrog.uvmqualification.model.Profesor
import com.lanavarrog.uvmqualification.ui.fragments.Schedule

class FireStoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    constructor(){
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSchedule(callback: Callback<List<Materia>>){
        firebaseFirestore.collection("alumnos").document("a010118169@my.uvm.edu.mx").collection("materias")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Materia::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getProfesors(callback: Callback<List<Profesor>>){
        firebaseFirestore.collection("alumnos").document("a010118169@my.uvm.edu.mx").collection("profesor")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Profesor::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }
}