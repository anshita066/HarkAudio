package com.harkaudio.fragments.search.podcasts

import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.harkaudio.fragments.search.harklist.ProductUrl.profileImageFormat
import com.harkaudio.fragments.search.harklist.harklist_dataclasses.Question

import com.harkaudio.replica.R

class PodcastRecyclerAdapter() : Filterable, RecyclerView.Adapter<PodcastRecyclerAdapter.MyHolder>() {
    private var questionList: MutableList<Question> = java.util.ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.data_items, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = questionList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {


    }



//    fun updateList(titleList: ArrayList<Question>) {
//        questionList.clear()
//        questionList.addAll(titleList)
//
//        notifyDataSetChanged()
//
//    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        var itemTitle: TextView = itemView.findViewById(R.id.tv1)
//        var creatorName: TextView = itemView.findViewById(R.id.tv2)
//        var contributor: TextView = itemView.findViewById(R.id.tv3)
//        var clipCount: TextView = itemView.findViewById(R.id.tv4)
//        var hrStr: TextView = itemView.findViewById(R.id.hr)
//        var hr: TextView = itemView.findViewById(R.id.tv5)
//        var min: TextView = itemView.findViewById(R.id.tv6)
//
//        var iv1: ImageView = itemView.findViewById(R.id.iv1)
//        var iv2: ImageView = itemView.findViewById(R.id.iv2)
//        var iv3: ImageView = itemView.findViewById(R.id.iv3)
//        var iv4: ImageView = itemView.findViewById(R.id.iv4)
//        var iv5: ImageView = itemView.findViewById(R.id.iv5)
//        var iv6: ImageView = itemView.findViewById(R.id.iv6)
//
//        var rootLayout: View = itemView.findViewById(R.id.rootLayout)

    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }

//    private fun filterList( titleList: fi){
//
//    }

}







