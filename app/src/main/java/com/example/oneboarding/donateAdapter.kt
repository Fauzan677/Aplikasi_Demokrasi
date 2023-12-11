package com.example.oneboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class donateAdapter(private val donateList: ArrayList<donate>)
    : RecyclerView.Adapter<donateAdapter.donateViewHolder> (){


    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): donateAdapter.donateViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_donate,
            parent,false)
        return donateAdapter.donateViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: donateAdapter.donateViewHolder, position: Int) {

        val currentItem = donateList[position]
        holder.ImageView.setImageResource(currentItem.imgDonate)
        holder.heading.text = (currentItem.heading)


    }

    override fun getItemCount(): Int {
        return donateList.size
    }

    class donateViewHolder(itemView: View, listener: donateAdapter.onItemClickListener): RecyclerView.ViewHolder(itemView) {

        //ini bisa salah
        val ImageView: ImageView = itemView.findViewById(R.id.img_item_photo4)
        val heading: TextView = itemView.findViewById(R.id.tv_item_name4)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }
}