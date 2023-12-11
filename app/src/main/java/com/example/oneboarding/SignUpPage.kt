package com.example.oneboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SignUpPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)
    }

    fun buat(view: View) {
        val intent = Intent(this, LoginPage:: class.java)
        startActivity(intent)
    }

    fun masuk(view: View) {
        val intent = Intent(this, LoginPage:: class.java)
        startActivity(intent)
    }
}