package com.example.oneboarding.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oneboarding.*


class HomeFragment : Fragment() {


    private lateinit var newRecylerview1 : RecyclerView
    private lateinit var newRecylerview2 : RecyclerView
    private lateinit var adapter: beritaAdapter
    private lateinit var adapter1: beritaAdapter1

    private val dataList = mutableListOf<berita1>()
    private lateinit var newArrayList: ArrayList<berita>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var desc : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = arrayOf(
            R.drawable.imgberita11,
            R.drawable.imgberita2,
            R.drawable.imgberita3,
            R.drawable.imgberita4,
            R.drawable.imgberita5,
        )

        title = arrayOf(
            "Nasib Wisata Jogja yang Sepi pada Lebaran Tahun ini ketimbang 2022 Butuh Evaluasi",
            "Liburan Lebaran telah usai, kawasan Malioboro dipenuhi tumpukan sampah",
            "Rencana Tol Jogja - YIA Kulon Progo, Cek Rute dan Lokasi Gerbang Tol Ada di Daerah Ini",
            "UPDATE Covid-19 DI Yogyakarta 8 Mei 2023: Tambah 24 Kasus Baru, 2 Pasien Meninggal",
            "Jadwal KRL Solo-Jogja Terbaru Per 2 Mei 2023 dari Stasiun Palur hingga Tugu Yogyakarta",

            )
        desc = arrayOf(
            getString(R.string.berita_wisata),
            "Belim ada",
            "Belum ada",
            "Belum ada",
            "Belum ada",
        )
//        tambah ini
        val imageViewAdd: ImageView = view.findViewById(R.id.imageViewAdd)
        imageViewAdd.setOnClickListener {
            openAddActivity()
        }

//        bagian profil
        val imageViewMenu: ImageView = view.findViewById(R.id.logprofil)
        imageViewMenu.setOnClickListener {
            val intent = Intent(activity, ProfilePage::class.java)
            startActivity(intent)
        }

        newRecylerview1 = view.findViewById(R.id.Berita)
        newRecylerview2 = view.findViewById(R.id.post)
        newRecylerview1.layoutManager = LinearLayoutManager(context)
        newRecylerview2.layoutManager = LinearLayoutManager(context)
        newRecylerview1.setHasFixedSize(true)
        newRecylerview2.setHasFixedSize(true)
        adapter1 = beritaAdapter1(dataList)
//        newRecylerview2.adapter = adapter1
        newArrayList = arrayListOf<berita>()
        getUserdata()
        getData()


    }
//    gua nambahin ini
    private fun openAddActivity() {
        val intent = Intent(activity, AddActivity::class.java)
        startActivityForResult(intent, ADD_ACTIVITY_REQUEST_CODE)
    }

    private fun getUserdata() {

        for (i in image.indices) {

            val berita = berita(image[i], title[i])
            newArrayList .add(berita)

        }

        adapter = beritaAdapter(newArrayList)
        newRecylerview1.adapter = adapter
        adapter.setonItemClickListener(object : beritaAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@detailPemimpinActivity2, "kamu click ini. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, DetailBeritaActivity::class.java )
                intent.putExtra("title",newArrayList[position].nameBerita)
                intent.putExtra("image", newArrayList[position].imgBerita)
                intent.putExtra("desc", desc[position])
                startActivity(intent)
            }

        })

    }

    private fun getData () {
//        adapter1 = beritaAdapter1(dataList)
//        newRecylerview2.adapter = adapter1
        adapter1.setonItemClickListener(object : beritaAdapter1.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@detailPemimpinActivity2, "kamu click ini. $position", Toast.LENGTH_SHORT).show()
//                val post = Intent(activity, DetailBeritaActivity1::class.java )
////                post.putExtra("title",dataList[position].heading)
//                post.putExtra("image", dataList[position].imageResId)
//                post.putExtra("description", desc[position])
//                startActivity(post)
            }

        })
        newRecylerview2.adapter = adapter1
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val heading = data?.getStringExtra(AddActivity.HEADING_EXTRA)
            val description = data?.getStringExtra(AddActivity.DESCRIPTION_EXTRA)
            val imageUriString = data?.getStringExtra(AddActivity.IMAGE_URI_EXTRA)

            if (heading != null && description != null && imageUriString != null) {
                val imageUri = Uri.parse(imageUriString)
                val imageBitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, imageUri)
                val newData = berita1(imageBitmap, heading, description)
                dataList.add(newData)
                adapter1.notifyItemInserted(dataList.size - 1)
                newRecylerview2.scrollToPosition(dataList.size - 1)
            }
        }
    }

//    sama ini juga
    companion object {
        private const val ADD_ACTIVITY_REQUEST_CODE = 1001
    }

}