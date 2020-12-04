package com.lanavarrog.uvmqualification.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lanavarrog.uvmqualification.R
import com.lanavarrog.uvmqualification.ui.model.Alumno

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
        val user = auth.currentUser

        if(user != null){
            val alumno: Alumno
        }else{
            goLogin()
        }

    }

    fun goLogin(){
        var intent = Intent(this,Auth::class.java)
        startActivity(intent)
    }


}