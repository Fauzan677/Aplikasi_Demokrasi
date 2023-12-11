package com.example.oneboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//ini untuk fragment
class pemimpinAdapter(private val pemimpinList: ArrayList<pemimpin>)
    : RecyclerView.Adapter<pemimpinAdapter.pemimpinViewHolder> (){

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setonItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pemimpinViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_detailpemimpin,
            parent,false)
        return pemimpinAdapter.pemimpinViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: pemimpinViewHolder, position: Int) {

        val currentItem = pemimpinList[position]
        holder.ImageView.setImageResource(currentItem.imgPemimpin)
        holder.namaWalikota.text = (currentItem.nameWalikota)
        holder.priode.text = (currentItem.priode)


    }

    override fun getItemCount(): Int {
        return pemimpinList.size
    }

    class pemimpinViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {
        //ini bisa salah
        val ImageView: ImageView = itemView.findViewById(R.id.img_item_photo3)
        val namaWalikota: TextView = itemView.findViewById(R.id.tv_item_name3)
        val priode : TextView = itemView.findViewById(R.id.tv_item_priode)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        //    ini saya buat untuk click
//        fun bindView(pemimpin: pemimpin, listener: (pemimpin) -> Unit) {
//            ImageView.setImageResource(pemimpin.imgPemimpin)
//            namaWalikota.text = pemimpin.nameWalikota
//            priode.text = pemimpin.priode
//            itemView.setOnClickListener {
//                listener(pemimpin)
//            }
//        }
    }

}