package com.harkaudio.fragments.search.profiles

import Member
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.harkaudio.fragments.search.clips.ProductUrlClips
import com.harkaudio.fragments.search.harklist.harklist_dataclasses.Question

import com.harkaudio.replica.R

class ProfilesRecyclerAdapter() : Filterable, RecyclerView.Adapter<ProfilesRecyclerAdapter.MyHolder>() {
    private var memberList: MutableList<Member> = java.util.ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.profile_items, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = memberList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val memberName = memberList[position]

        val name = memberName.name ?: "unknown"

        holder.heading1.text = name
        holder.heading2.text = memberName.userName

        val creatorImage = String.format(ProductUrlProfiles.profileImageFormat, memberName.uid)

        val imageHolder = holder.iv1

        Glide.with(holder.itemView)
            .load(creatorImage)
            .into(imageHolder)

    }

    fun updateList(titleList: ArrayList<Member>) {
        memberList.clear()
        memberList.addAll(titleList)

        notifyDataSetChanged()

    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var heading1: TextView = itemView.findViewById(R.id.tv1)
        var heading2: TextView = itemView.findViewById(R.id.tv2)
        var heading3: TextView = itemView.findViewById(R.id.tv3)
        var follow: TextView = itemView.findViewById(R.id.tv4)


        var iv1: ImageView = itemView.findViewById(R.id.iv1)

    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }

//    private fun filterList( titleList: fi){
//
//    }

}







