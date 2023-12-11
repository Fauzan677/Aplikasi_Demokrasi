package com.example.oneboarding.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oneboarding.*


class ProfileFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val yogyakarta = view.findViewById<View>(R.id.yogyakarta1)
        // Mengatur OnClickListener untuk tombol
        yogyakarta.setOnClickListener {
            // Membuat Intent untuk memulai Activity baru
            val intent = Intent(activity, detailPemimpinActivity1::class.java)
            startActivity(intent)
        }

        //        bagian profil
        val imageViewMenu: ImageView = view.findViewById(R.id.logprofil)
        imageViewMenu.setOnClickListener {
            val intent = Intent(activity, ProfilePage::class.java)
            startActivity(intent)
        }

    }





}