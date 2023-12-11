package com.example.oneboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oneboarding.fragment.DescFragment
import com.example.oneboarding.fragment.ProfileFragment

class detailPemimpinActivity1 : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pemimpin1)
    }


    fun Walikota(view: View) {
        val intent = Intent(this, detailPemimpinActivity2:: class.java)
        startActivity(intent)
    }

    fun DPRD(view: View) {
        val intent = Intent(this, detailPemimpinActivity3:: class.java)
        startActivity(intent)
    }

    fun back(view: View) {
        onBackPressed()
    }


}