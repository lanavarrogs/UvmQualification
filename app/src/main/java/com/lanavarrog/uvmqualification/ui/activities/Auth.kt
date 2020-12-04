package com.lanavarrog.uvmqualification.ui.activities


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.lanavarrog.uvmqualification.R
import kotlinx.android.synthetic.main.activity_auth.*




class Auth : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        auth = Firebase.auth


        //Setup
        Setup()

    }

    fun Setup(){
        var email:String = ""
        var password: String = ""
        btnSignIn.setOnClickListener {
            if(etEmail.text.isNotEmpty() && etPassword.text.isNotEmpty() ){
                email = etEmail.text.toString()
                password = etPassword.text.toString()
                SignIn(it,email,password)
            }
        }
    }

    fun typeMail(){

    }

    fun SignIn(it: View,email: String, password: String){
        this.auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, OnCompleteListener<AuthResult> { task->
            if(task.isSuccessful) {
                goToHome()
                showMessage(it,"Login Succesful")
            }else{
                showMessage(it,"Error de autenticacion")
            }
        })
    }


    fun goToHome(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    fun showMessage(it:View, message: String){
        Snackbar.make(it,message,Snackbar.LENGTH_INDEFINITE).setAction("Action",null).show()
    }



}