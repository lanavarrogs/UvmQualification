package com.lanavarrog.uvmqualification.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.lanavarrog.uvmqualification.R
import kotlinx.android.synthetic.main.activity_splashscreen.*


class Splashscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val animacion = AnimationUtils.loadAnimation(this,R.anim.animacion)
        ivLogoUvm.startAnimation(animacion)

        val intent = Intent(this, Auth::class.java)

        animacion.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })

    }
}