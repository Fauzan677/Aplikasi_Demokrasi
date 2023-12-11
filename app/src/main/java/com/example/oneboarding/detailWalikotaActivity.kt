package com.example.oneboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class detailWalikotaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_walikota)

        val imgPemimpin : ImageView = findViewById(R.id.img_item_photo3)
        val maindesc : TextView = findViewById(R.id.tv_item_news)
        val namePemimpin : TextView = findViewById(R.id.tv_item_name3)



        val bundle : Bundle?= intent.extras
        val imageId = bundle!!.getInt("imageId")
        val heading = bundle.getString("heading")
        val desc =bundle.getString("desc")

        imgPemimpin.setImageResource(imageId)
        namePemimpin.text = heading
        maindesc.text = desc
    }

    fun back(view: View) {
        onBackPressed()
    }
}