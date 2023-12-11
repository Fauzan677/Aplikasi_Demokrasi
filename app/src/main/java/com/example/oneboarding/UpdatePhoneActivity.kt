package com.example.oneboarding

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class UpdatePhoneActivity : AppCompatActivity() {

    private lateinit var updatedPhone: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_phone)

        val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
        val previousPhone = intent.getStringExtra("previous_phone")
        phoneEditText.setText(previousPhone)

        findViewById<Button>(R.id.updateButton).setOnClickListener {
            updatedPhone = phoneEditText.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("new_phone", updatedPhone)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}

