package com.example.oneboarding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.oneboarding.fragment.HomeFragment

class DetailBeritaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        val imgBerita = findViewById<ImageView>(R.id.img_item_photo)
        val maindesc = findViewById<TextView>(R.id.tv_item_desc)

        val bundle : Bundle?= intent.extras
        val imageId = bundle!!.getInt("image")
        val desc =bundle.getString("desc")

        imgBerita.setImageResource(imageId)
        maindesc.text = desc

    }


    fun back(view: View) {
        onBackPressed()
    }

    fun komen(view: View) {
        val intent = Intent(this, Komen:: class.java)
        startActivity(intent)
    }
}