package com.lanavarrog.uvmqualification.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.lanavarrog.uvmqualification.R
import com.lanavarrog.uvmqualification.model.Alumno
import kotlinx.android.synthetic.main.fragment_scolar_info.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ScolarInfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScolarInfo : Fragment() {
    private lateinit var auth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        auth = Firebase.auth
        val user = auth.currentUser
        if(user != null ){
            var email = user.email.toString()
            db.collection("alumno").document(email).get().addOnSuccessListener {
                var firstname = it.get("name") as String
                var lastname = it.get("lastname") as String
                var name = firstname.plus(" ").plus(lastname)
                var edad = it.get("edad") as Number
                tvDetailMatricula.setText(it.get("matricula") as String)
                tvDetailName.setText(name)
                tvDetailAge.setText(edad.toString())
                tvDetailCarrera.setText(it.get("carrera") as String)
            }
        }
        return inflater.inflate(R.layout.fragment_scolar_info, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ScolarInfo().apply {

                }
    }


}