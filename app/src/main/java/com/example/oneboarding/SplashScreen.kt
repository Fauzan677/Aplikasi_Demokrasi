package com.example.oneboarding

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen: AppCompatActivity(){
    private lateinit var gambar_loading: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashscreen_layout)
        gambar_loading = findViewById(R.id.gambar_splashscreen)

        supportActionBar?.hide()

        setAnimation()

        Handler().postDelayed({
            startActivity(
                Intent(
                    this@SplashScreen,
                    MainActivity::class.java)
            )
        },3000)

    }

    private fun setAnimation(){
        val animaiton = AnimationUtils.loadAnimation(
            this@SplashScreen,
            R.anim.top_animation)
        gambar_loading.animation = animaiton
    }
}