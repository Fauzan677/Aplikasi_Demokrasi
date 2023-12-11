package com.example.oneboarding

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class UpdateEmailActivity : AppCompatActivity() {

    private lateinit var updatedEmail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_email)

        // Mendapatkan referensi ke EditText untuk masukan email baru
        val emailEditText = findViewById<EditText>(R.id.emailEditText)

        // Mendapatkan email sebelumnya dari intent (opsional, jika ingin menampilkan nilai sebelumnya)
        val previousEmail = intent.getStringExtra("previous_email")
        emailEditText.setText(previousEmail)

        // Memberikan onClickListener ke tombol Update
        findViewById<Button>(R.id.updateButton).setOnClickListener {
            // Mendapatkan email baru dari EditText
            updatedEmail = emailEditText.text.toString()

            // Mengirim kembali email baru ke ProfilePage
            val resultIntent = Intent()
            resultIntent.putExtra("new_email", updatedEmail)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
