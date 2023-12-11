package com.example.oneboarding

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class AddActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var editTextHeading: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var buttonUploadImage: Button
    private lateinit var buttonAdd: Button

    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        imageView = findViewById(R.id.imageView)
        editTextHeading = findViewById(R.id.editTextHeading)
        editTextDescription = findViewById(R.id.editTextDescription)
        buttonUploadImage = findViewById(R.id.buttonUploadImage)
        buttonAdd = findViewById(R.id.buttonAdd)

        buttonUploadImage.setOnClickListener {
            openGallery()
        }

        buttonAdd.setOnClickListener {
            val heading = editTextHeading.text.toString()
            val description = editTextDescription.text.toString()

            val dataIntent = Intent().apply {
                putExtra(HEADING_EXTRA, heading)
                putExtra(DESCRIPTION_EXTRA, description)
                putExtra(IMAGE_URI_EXTRA, selectedImageUri?.toString())
            }
            setResult(RESULT_OK, dataIntent)
            finish()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, IMAGE_PICK_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IMAGE_PICK_REQUEST_CODE && resultCode == RESULT_OK) {
            selectedImageUri = data?.data
            imageView.setImageURI(selectedImageUri)
        }
    }

    companion object {
        const val HEADING_EXTRA = "heading_extra"
        const val DESCRIPTION_EXTRA = "description_extra"
        const val IMAGE_URI_EXTRA = "image_uri_extra"
        private const val IMAGE_PICK_REQUEST_CODE = 1001
    }

    fun back(view: View) {
        onBackPressed()
    }

}