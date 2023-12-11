package com.example.oneboarding

import android.bluetooth.BluetoothHeadset
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class detailPemimpinActivity2 : AppCompatActivity() {

    private lateinit var newRecylerview : RecyclerView
    private lateinit var  newArrayList : ArrayList<pemimpin>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var priode : Array<String>
    lateinit var desc : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pemimpin2)

        imageId = arrayOf(
            R.drawable.walikota1
        )

        heading = arrayOf(
            "Pejabat Walikota Yogyakarta"
        )

        priode = arrayOf(
            "Periode 2022-Petahana"
        )

        desc = arrayOf(
            getString(R.string.biodata_walikota_jogja)
        )

        newRecylerview = findViewById(R.id.Walikota)
        newRecylerview.layoutManager = LinearLayoutManager(this)
        newRecylerview.setHasFixedSize(true)

        newArrayList = arrayListOf<pemimpin>()
        getUserdata()


    }

    private fun getUserdata() {

        for (i in imageId.indices) {

            val walikota = pemimpin(imageId[i], heading[i], priode[i])
            newArrayList .add(walikota)

        }

        var adapter = pemimpinAdapter(newArrayList)
        newRecylerview.adapter = adapter
        adapter.setonItemClickListener(object : pemimpinAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@detailPemimpinActivity2, "kamu click ini. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@detailPemimpinActivity2, detailWalikotaActivity::class.java )
                intent.putExtra("heading",newArrayList[position].nameWalikota)
                intent.putExtra("imageId", newArrayList[position].imgPemimpin)
                intent.putExtra("priode", newArrayList[position].priode)
                intent.putExtra("desc", desc[position])
                startActivity(intent)
            }


        })

    }

    fun back(view: View) {
        onBackPressed()
    }
}