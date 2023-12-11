package com.example.oneboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class detailPemimpinActivity3 : AppCompatActivity() {
    private lateinit var newRecylerview : RecyclerView
    private lateinit var  newArrayList : ArrayList<pemimpin>

    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var priode : Array<String>
    lateinit var desc : Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pemimpin3)

        imageId = arrayOf(
            R.drawable.dprd1,
            R.drawable.dprd2,
            R.drawable.dprd3,
            R.drawable.dprd4,
        )

        heading = arrayOf(
            "Ketua DPRD Yogyakarta",
            "Wakil DRPD Yogyakarta",
            "Wakil DRPD Yogyakarta",
            "Wakil DRPD Yogyakarta"
        )

        priode = arrayOf(
            "Periode 2019-2024",
            "Periode 2019-2024",
            "Periode 2019-2024",
            "Periode 2019-2024"
        )
        desc = arrayOf(
            getString(R.string.biodata_dprd),
            "Not empty",
            "Not empty",
            "Not empty"
        )

        newRecylerview = findViewById(R.id.DPRD)
        newRecylerview.layoutManager = LinearLayoutManager(this)
        newRecylerview.setHasFixedSize(true)

        newArrayList = arrayListOf<pemimpin>()
        getUserdata()


    }

    private fun getUserdata() {

        for (i in imageId.indices) {

            val DPRD = pemimpin(imageId[i], heading[i], priode[i])
            newArrayList .add(DPRD)

        }
        var adapter = pemimpinAdapter(newArrayList)
        newRecylerview.adapter = adapter
        adapter.setonItemClickListener(object : pemimpinAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@detailPemimpinActivity3, "kamu click ini. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@detailPemimpinActivity3, detailDPRDActivity::class.java )
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

