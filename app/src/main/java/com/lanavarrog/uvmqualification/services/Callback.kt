package com.lanavarrog.uvmqualification.services

import java.lang.Exception

interface Callback<T>{
    fun onSuccess(result: T?)

    fun onFailed(exception: Exception)
}