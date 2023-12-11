package com.example.oneboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class detailDonateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_donate)


        val imgDonate : ImageView = findViewById(R.id.img_item_photo4)
        val maindesc : TextView = findViewById(R.id.dn_txt_isi)

        val bundle : Bundle?= intent.extras
        val imageId = bundle!!.getInt("imageId")
        val desc =bundle.getString("desc")

        imgDonate.setImageResource(imageId)
        maindesc.text = desc


    }

    fun back(view: View) {
        onBackPressed()
    }

    fun makanan(view: View) {
        val intent = Intent(this, descMakananActivity:: class.java)
        startActivity(intent)
    }

    fun uang(view: View) {
        val intent = Intent(this, descUangActivity:: class.java)
        startActivity(intent)
    }
}