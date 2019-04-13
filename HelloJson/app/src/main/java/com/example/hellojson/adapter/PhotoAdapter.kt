package com.example.hellojson.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.hellojson.R
import com.example.hellojson.model.PhotoModel
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoAdapter(val model: ArrayList<PhotoModel>): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PhotoViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_photo, p0, false)
        return PhotoViewHolder(view)
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(p0: PhotoViewHolder, p1: Int) = p0.bind(model[p1])

    inner class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val albumId = itemView.findViewById<TextView>(R.id.tvAlbumId)
        val title = itemView.findViewById<TextView>(R.id.tvTitle)

        fun bind(model: PhotoModel) {
            with(itemView) {
                albumId.text = model.albumId
                title.text = model.title

                Glide.with(context)
                    .load(model.url)
                    .fitCenter()
                    .into(imagePhoto)
            }
        }
    }
}