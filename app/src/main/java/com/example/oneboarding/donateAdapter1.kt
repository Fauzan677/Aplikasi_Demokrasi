package com.example.oneboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class donateAdapter1(private val dataList: List<donate1>) :
    RecyclerView.Adapter<donateAdapter1.ViewHolder>() {

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_berita1, parent, false)
        return ViewHolder(view,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View, listener: donateAdapter1.onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.img_item_post)
        private val textViewHeading: TextView = itemView.findViewById(R.id.tv_item_heading)
//        private val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)

        fun bind(data: donate1) {
            imageView.setImageBitmap(data.imageResId)
            textViewHeading.text = data.heading
//            textViewDescription.text = data.description

        }
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}