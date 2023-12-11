package com.example.oneboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class keresahanAdapter(private val keresahanList: ArrayList<keresahan>)
    : RecyclerView.Adapter<keresahanAdapter.keresahanViewHolder> (){


    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): keresahanAdapter.keresahanViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_keresahan,
            parent,false)
        return keresahanAdapter.keresahanViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: keresahanAdapter.keresahanViewHolder, position: Int) {

        val currentItem = keresahanList[position]
        holder.ImageView.setImageResource(currentItem.imgKeresahan)
        holder.namaKeresahan.text = (currentItem.nameKeresahan)
    }

    override fun getItemCount(): Int {
        return keresahanList.size
    }

    class keresahanViewHolder(itemView: View, listener: keresahanAdapter.onItemClickListener): RecyclerView.ViewHolder(itemView) {

        //ini bisa salah
        val ImageView: ImageView = itemView.findViewById(R.id.img_item_photo1)
        val namaKeresahan: TextView = itemView.findViewById(R.id.tv_item_name1)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}
