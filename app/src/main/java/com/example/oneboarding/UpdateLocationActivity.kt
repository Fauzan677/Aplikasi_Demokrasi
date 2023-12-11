package com.example.oneboarding

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class UpdateLocationActivity : AppCompatActivity() {

    private lateinit var updatedLocation: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_location)

        val locationEditText = findViewById<EditText>(R.id.locationEditText)
        val previousLocation = intent.getStringExtra("previous_location")
        locationEditText.setText(previousLocation)

        findViewById<Button>(R.id.updateButton).setOnClickListener {
            updatedLocation = locationEditText.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("new_location", updatedLocation)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}

