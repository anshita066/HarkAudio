package com.harkaudio.fragments.search.clips

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.harkaudio.fragments.search.clips.ProductUrlClips.profileImageFormat
import com.harkaudio.fragments.search.clips.clips_dataclasses.Answer
import com.harkaudio.replica.R

class ClipsRecyclerAdapter: Filterable, RecyclerView.Adapter<ClipsRecyclerAdapter.MyHolder>() {
    private var answerList: MutableList<Answer> = java.util.ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.clip_items, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = answerList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val ansTitle = answerList[position]

        val title = ansTitle.title

        holder.clipTitle.text = title
        holder.clipsubtitle.text = ansTitle.creator.name

        val creatorImage = String.format(ProductUrlClips.imageUrlFormat, ansTitle.customAttributes.podcast.podcastImageHash)

        val imageHolder = holder.iv1

        Glide.with(holder.itemView)
            .load(creatorImage)
            .into(imageHolder)

        val time = ansTitle.customAttributes.podcast.duration

        var min = time/60
        val hr = min / 60

        holder.clipmin.text = min.toString()

        if (min > 60) {
            min -= 60
            holder.clipmin.text = min.toString()

            holder.cliphr.text = hr.toString()
        }
        else if (min<60)
            holder.cliphr.text = "0"

    }

    fun updateList(titleList: ArrayList<Answer>) {
        answerList.clear()
        answerList.addAll(titleList)

        notifyDataSetChanged()

    }
    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var clipTitle: TextView = itemView.findViewById(R.id.tv1)
        var clipsubtitle: TextView = itemView.findViewById(R.id.tv2)
        var cliphr: TextView = itemView.findViewById(R.id.tv3)
        var clipmin: TextView = itemView.findViewById(R.id.tv4)

        var iv1: ImageView = itemView.findViewById(R.id.iv1)
    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }
}