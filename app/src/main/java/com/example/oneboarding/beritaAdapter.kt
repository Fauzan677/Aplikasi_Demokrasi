package com.example.oneboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//maksud dari listener (berita) adalah berita itu dari nama model
class beritaAdapter(private val beritaList: ArrayList<berita>)
    : RecyclerView.Adapter<beritaAdapter.beritaViewHolder> () {


    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): beritaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_berita,
            parent,false)
        return beritaAdapter.beritaViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: beritaAdapter.beritaViewHolder, position: Int) {

        val currentItem = beritaList[position]
        holder.ImageView.setImageResource(currentItem.imgBerita)
        holder.namaberita.text = (currentItem.nameBerita)


    }

    override fun getItemCount(): Int {
        return beritaList.size
    }

    class beritaViewHolder(itemView: View, listener: beritaAdapter.onItemClickListener): RecyclerView.ViewHolder(itemView) {

        //ini bisa salah
        val ImageView: ImageView = itemView.findViewById(R.id.img_item_photo)
        val namaberita: TextView = itemView.findViewById(R.id.tv_item_name)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}
