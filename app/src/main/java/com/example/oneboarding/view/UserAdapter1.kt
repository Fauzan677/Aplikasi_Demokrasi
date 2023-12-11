package com.example.oneboarding.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.oneboarding.R
import com.example.oneboarding.model.Use

class UserAdapter1(private val komenList: List<Use>)
    : RecyclerView.Adapter<UserAdapter1.komenViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter1.komenViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_komen,
            parent,false)
        return komenViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserAdapter1.komenViewHolder, position: Int) {

        val currentItem = komenList[position]
        holder.namaUser.text = (currentItem.user)
        holder.title.text = (currentItem.title)

    }

    override fun getItemCount(): Int {
        return komenList.size
    }

    class komenViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //ini bisa salah
        val namaUser: TextView = itemView.findViewById(R.id.akun)
        val title : TextView = itemView.findViewById(R.id.mTitle)

    }
}