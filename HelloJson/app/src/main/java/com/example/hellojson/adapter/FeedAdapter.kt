package com.example.hellojson.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.hellojson.R
import com.example.hellojson.model.FeedModel

class FeedAdapter(val model: ArrayList<FeedModel>): RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_feed, viewGroup, false)
        return FeedViewHolder(view)
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(viewHolder: FeedViewHolder, position: Int) = viewHolder.bind(model[position])

    inner class FeedViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val userId = itemView.findViewById<TextView>(R.id.userid_result)
        val id = itemView.findViewById<TextView>(R.id.id_result)
        val title = itemView.findViewById<TextView>(R.id.title_result)
        val body = itemView.findViewById<TextView>(R.id.body_result)

        fun bind(model: FeedModel) {
            userId.text = model.userId
            id.text = model.Id
            title.text = model.title
            body.text = model.body
        }
    }
}