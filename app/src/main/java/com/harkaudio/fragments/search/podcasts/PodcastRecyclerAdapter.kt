package com.harkaudio.fragments.search.podcasts

import Podcast

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.harkaudio.fragments.search.harklist.ProductUrl
import com.harkaudio.fragments.search.podcasts.podcast_dataclasses.EpisodeDetail


import com.harkaudio.replica.R

class PodcastRecyclerAdapter() : Filterable, RecyclerView.Adapter<PodcastRecyclerAdapter.MyHolder>() {
    private var questionList: MutableList<EpisodeDetail> = java.util.ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.podcast_items, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = questionList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val podcastList = questionList[position]

        holder.name.text = podcastList.name
        holder.artistName.text = podcastList.artistName

        val creatorImage = podcastList.image

        Glide.with(holder.iv1)
            .load(creatorImage)
            .into(holder.iv1)
    }


    fun updateList(titleList: ArrayList<EpisodeDetail>) {
        questionList.clear()
        questionList.addAll(titleList)

        notifyDataSetChanged()

    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView = itemView.findViewById(R.id.tv1)
        var artistName: TextView = itemView.findViewById(R.id.tv2)

        var iv1: ImageView = itemView.findViewById(R.id.iv1)

    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }

}







