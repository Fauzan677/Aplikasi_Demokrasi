package com.example.oneboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
    }

    fun login(view: View) {
        val intent = Intent(this, HomeActivity:: class.java)
        startActivity(intent)


    }

    fun Daftar(view: View) {
        val intent = Intent(this, SignUpPage:: class.java)
        startActivity(intent)
    }

    fun password(view: View) {
        val intent = Intent(this, ForgetPassword:: class.java)
        startActivity(intent)
    }
    override fun onBackPressed() {
        finishAffinity()
    }
}