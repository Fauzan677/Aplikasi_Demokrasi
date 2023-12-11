package com.example.oneboarding.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oneboarding.*


class DescFragment : Fragment() {


    private lateinit var newRecylerview1 : RecyclerView
    private lateinit var newRecylerview2 : RecyclerView
    private lateinit var adapter: keresahanAdapter
    private lateinit var adapter1: keresahanAdapter1

    private val dataList = mutableListOf<keresahan1>()
    private lateinit var newArrayList: ArrayList<keresahan>

//    private lateinit var menuAnchorView: View

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var desc : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_desc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = arrayOf(
            R.drawable.imguneg1,
            R.drawable.imguneg2,
            R.drawable.imguneg3,
            R.drawable.imguneg4,
            R.drawable.imguneg5,
        )

        title = arrayOf(
            "Jogja sepi disaat libur panjang lebaran 2023",
            "Jalan rusak di Provinsi Tempel Klangon",
            "Aksi Klitih saat ini mulai menyerang kaca mobil",
            "Penggunaan Lampu tambahan yang melanggar aturan",
            "Pencurian Handphone dan uang tunai di rental daerah Sorowajan",
        )

        desc = arrayOf(
            getString(R.string.keresahan_parkir),
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
        //ini bagian profil
//        menuAnchorView = view.findViewById(R.id.logprofil)
        val imageViewMenu: ImageView = view.findViewById(R.id.logprofil)
        imageViewMenu.setOnClickListener {
            val intent = Intent(activity, ProfilePage::class.java)
            startActivity(intent)
        }

        newRecylerview1 = view.findViewById(R.id.Keresahan)
        newRecylerview2 = view.findViewById(R.id.post)
        newRecylerview1.layoutManager = LinearLayoutManager(context)
        newRecylerview2.layoutManager = LinearLayoutManager(context)
        newRecylerview1.setHasFixedSize(true)
        newRecylerview2.setHasFixedSize(true)
        adapter1 = keresahanAdapter1(dataList)
        newArrayList = arrayListOf<keresahan>()
        getUserdata()
        getData ()

    }
//buat tampilan menu
//    private fun showMenu() {
//        val popupMenu = PopupMenu(requireContext(),menuAnchorView )
//        popupMenu.menuInflater.inflate(R.menu.profile_menu, popupMenu.menu)
//        popupMenu.setOnMenuItemClickListener { item ->
//            when (item.itemId) {
//                R.id.username -> {
//                    // Tambahkan kode untuk menu Profile di sini
//                    val intent = Intent(activity, ProfilePage::class.java)
//                    startActivity(intent)
//                    true
//                }
//                R.id.log -> {
//                    // Tambahkan kode untuk menu Logout di sini
//                    val intent = Intent(activity, LoginPage::class.java)
//                    startActivity(intent)
//                    true
//                }
//                else -> false
//            }
//        }
//
//        popupMenu.show()
//    }


    //    gua nambahin ini
    private fun openAddActivity() {
        val intent = Intent(activity, AddActivity::class.java)
        startActivityForResult(intent, ADD_ACTIVITY_REQUEST_CODE)
    }

    //Recylerview awal
    private fun getUserdata() {

        for (i in image.indices) {

            val keresahan = keresahan(image[i], title[i])
            newArrayList .add(keresahan)

        }

        adapter = keresahanAdapter(newArrayList)
        newRecylerview1.adapter = adapter
        adapter.setonItemClickListener(object : keresahanAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@detailPemimpinActivity2, "kamu click ini. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(activity, DetailKeresahanActivity::class.java )
                intent.putExtra("title",newArrayList[position].nameKeresahan)
                intent.putExtra("imageId", newArrayList[position].imgKeresahan)
                intent.putExtra("desc", desc[position])
                startActivity(intent)
            }


        })

    }
//    Recylerview post
    private fun getData () {
//        adapter1 = beritaAdapter1(dataList)
//        newRecylerview2.adapter = adapter1
        adapter1.setonItemClickListener(object : keresahanAdapter1.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@detailPemimpinActivity2, "kamu click ini. $position", Toast.LENGTH_SHORT).show()
//                val post = Intent(activity, DetailBeritaActivity1::class.java )
//                post.putExtra("title",dataList[position].heading)
//                post.putExtra("image", dataList[position].imageResId)
//                post.putExtra("desc", desc[position])
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
                val newData = keresahan1(imageBitmap, heading, description)
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
