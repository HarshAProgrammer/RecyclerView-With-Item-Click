package com.example.recyclerview

import android.app.Activity
import android.graphics.text.TextRunShaper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList:ArrayList<News>,var context:Activity):RecyclerView.Adapter<MyAdapter.MyViewsHolder>(){

    private lateinit var myListener:onItemClickListener

    interface onItemClickListener{
        fun onClickItem(position:Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }

    class MyViewsHolder(itemView: View,listener:onItemClickListener):RecyclerView.ViewHolder(itemView) {
        var mHeading = itemView.findViewById<TextView>(R.id.tvHeadingTitle)
        var mImage = itemView.findViewById<ShapeableImageView>(R.id.ivHeadingImage)
        init {
            itemView.setOnClickListener{
                listener.onClickItem(adapterPosition)
            }
        }
    }


    //to create new view instance when view manager fails to find a view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewsHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return MyViewsHolder(itemView,myListener)
    }
    //populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewsHolder, position: Int) {
        var currentItem = newsArrayList[position]
        holder.mHeading.text = currentItem.newsHeading
        holder.mImage.setImageResource(currentItem.newsImage)



    }



    override fun getItemCount(): Int {
        return newsArrayList.size

    }


}
