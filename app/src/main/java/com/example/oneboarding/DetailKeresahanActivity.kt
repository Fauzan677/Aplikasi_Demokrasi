package com.example.oneboarding

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.oneboarding.fragment.DescFragment
import com.example.oneboarding.fragment.HomeFragment

class DetailKeresahanActivity : AppCompatActivity() {
    //    @SuppressLint("MissingInflatedId")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_keresahan)

        val imgKeresahan : ImageView = findViewById(R.id.img_item_photo1)
        val maindesc : TextView = findViewById(R.id.tv_item_desc)

        val bundle : Bundle?= intent.extras
        val imageId = bundle!!.getInt("imageId")
        val desc =bundle.getString("desc")

        imgKeresahan.setImageResource(imageId)
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