package com.lanavarrog.uvmqualification.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lanavarrog.uvmqualification.model.Materia
import com.lanavarrog.uvmqualification.services.Callback
import com.lanavarrog.uvmqualification.services.FireStoreService
import java.lang.Exception

class ScheduleViewModel(): ViewModel() {
    var firestoreService: FireStoreService
    var listScheduleViewModel: MutableLiveData<List<Materia>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    init {
        firestoreService = FireStoreService()
    }

    fun refresh(){
        getScheduleFromFirebase()
    }

    fun getScheduleFromFirebase(){
        firestoreService.getSchedule(object: Callback<List<Materia>>{
            override fun onSuccess(result: List<Materia>?) {
                listScheduleViewModel.postValue(result)
                proccessFinished()
            }
            override fun onFailed(exception: Exception) {
                proccessFinished()
            }
        })
    }

    fun proccessFinished(){
        isLoading.value=true
    }

}