package com.example.oneboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailBeritaActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita1)

        val imageView: ImageView = findViewById(R.id.img_item_post)

        val textViewDesc: TextView = findViewById(R.id.tv_item_desc1)

        val imageResId = intent.getIntExtra("image", 0)
        val desc = intent.getStringExtra("desc")

        imageView.setImageResource(imageResId)
        textViewDesc.text = desc
    }



    fun back(view: View) {
        onBackPressed()
    }

    fun komen(view: View) {
        val intent = Intent(this, Komen:: class.java)
        startActivity(intent)
    }
}
//        val imageView : ImageView = findViewById(R.id.img_item_post)
//        val textViewDesc : TextView = findViewById(R.id.tv_item_desc)
//
//        val imageResId = intent.getIntExtra("image", 0)
//        val desc = intent.getStringExtra("description")
//
//        imageView.setImageResource(imageResId)
//        textViewDesc.text = desc
