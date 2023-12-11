package com.example.oneboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oneboarding.model.Use
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.example.oneboarding.model.UserData
import com.example.oneboarding.view.UserAdapter
import com.example.oneboarding.view.UserAdapter1

class Komen : AppCompatActivity() {
    private lateinit var addsBtn:ImageView
    private lateinit var recv:RecyclerView
    private lateinit var newRecylerview : RecyclerView
    private lateinit var  newList : List<Use>

    private lateinit var userList:ArrayList<UserData>
    private lateinit var userAdapter1: UserAdapter1
    private lateinit var userAdapter:UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_komen)

        userList = ArrayList()

        addsBtn = findViewById(R.id.addingBtn)
        recv = findViewById(R.id.mRecycler)

        userAdapter = UserAdapter(this,userList)

        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter

        addsBtn.setOnClickListener { addInfo() }


        newList = listOf(
            Use("Ihza hafidz Robbani", "Emang bener yak kok saya tidak pernah mendengar fakta seperti ini"),
            Use("Muhammad faris Aiman", "apa iya bang"),
            Use("Fathin izzulhaq", "yang bener !!!"),
            // Tambahkan item lainnya sesuai kebutuhan
        )

        newRecylerview = findViewById(R.id.mRecycler1)
        newRecylerview.layoutManager = LinearLayoutManager(this)

        // Inisialisasi dan atur adapter RecyclerView
        userAdapter1 = UserAdapter1(newList)
        newRecylerview .adapter = userAdapter1

    }



    private fun addInfo() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item,null)

        val userName = v.findViewById<EditText>(R.id.userName)

        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
        addDialog.setPositiveButton("Ok"){
                dialog,_->
            val names = userName.text.toString()
            userList.add(UserData("$names"))
            userAdapter.notifyDataSetChanged()
            dialog.dismiss()
        }
        addDialog.setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()

        }
        addDialog.create()
        addDialog.show()
    }

    fun back(view: View) {
        onBackPressed()
    }

}