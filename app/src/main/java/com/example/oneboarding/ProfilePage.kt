package com.example.oneboarding


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.TextView


class ProfilePage : AppCompatActivity() {

    private lateinit var emailTextView: TextView
    private lateinit var phoneTextView: TextView
    private lateinit var locationTextView: TextView

    private val UPDATE_EMAIL_REQUEST_CODE = 1
    private val UPDATE_PHONE_REQUEST_CODE = 2
    private val UPDATE_LOCATION_REQUEST_CODE = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_page)

        emailTextView = findViewById(R.id.emailTextView)
        phoneTextView = findViewById(R.id.phoneTextView)
        locationTextView = findViewById(R.id.locationTextView)



        findViewById<View>(R.id.gmail).setOnClickListener {
            // Membuka activity UpdateEmailActivity untuk memperbarui email
            val intent = Intent(this@ProfilePage, UpdateEmailActivity::class.java)
            intent.putExtra("previous_email", emailTextView.text.toString()) // Mengirim email sebelumnya
            startActivityForResult(intent, UPDATE_EMAIL_REQUEST_CODE)
        }

        // Memberikan onClickListener ke CardView telepon
        findViewById<View>(R.id.phone).setOnClickListener {
            // Membuka activity UpdatePhoneActivity untuk memperbarui telepon
            val intent = Intent(this@ProfilePage, UpdatePhoneActivity::class.java)
            startActivityForResult(intent, UPDATE_PHONE_REQUEST_CODE)
        }

        // Memberikan onClickListener ke CardView lokasi
        findViewById<View>(R.id.location).setOnClickListener {
            // Membuka activity UpdateLocationActivity untuk memperbarui lokasi
            val intent = Intent(this@ProfilePage, UpdateLocationActivity::class.java)
            startActivityForResult(intent, UPDATE_LOCATION_REQUEST_CODE)
        }

        // Implementasikan metode onActivityResult untuk menerima hasil dari activity update


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Periksa requestCode dan resultCode untuk memastikan hasil yang benar
        if (resultCode == RESULT_OK) {
            when (requestCode) {
                UPDATE_EMAIL_REQUEST_CODE -> {
                    // Mendapatkan email baru dari hasil UpdateEmailActivity
                    val newEmail = data?.getStringExtra("new_email")

                    // Memperbarui nilai cardview email jika email baru tidak kosong
                    if (!newEmail.isNullOrBlank()) {
                        emailTextView.text = newEmail
                    }
                }
                UPDATE_PHONE_REQUEST_CODE -> {
                    val newPhone = data?.getStringExtra("new_phone")

                    if (!newPhone.isNullOrBlank()) {
                        phoneTextView.text = newPhone
                    }
                }
                UPDATE_LOCATION_REQUEST_CODE -> {
                    val newLocation = data?.getStringExtra("new_location")

                    if (! newLocation.isNullOrBlank()) {
                        locationTextView.text = newLocation
                    }
                }
            }
        }
    }


    fun back(view: View) {
        onBackPressed()
    }

    fun logout(view: View) {
        val intent = Intent(this, LoginPage:: class.java)
        startActivity(intent)
    }


}