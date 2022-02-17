package com.harkaudio.fragments.search.podcasts

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.harkaudio.fragments.search.podcasts.podcast_dataclasses.EpisodeDetail
import com.harkaudio.fragments.search.profiles.ProfilesItemModel
import com.harkaudio.replica.R

@EpoxyModelClass(layout = R.layout.podcast_items)
abstract class PodcastItemModel : EpoxyModelWithHolder<PodcastItemModel.Holder>() {

    @EpoxyAttribute
    private var questionList: MutableList<EpisodeDetail> = java.util.ArrayList()

    override fun bind(holder: ProfilesItemModel.Holder) {
        super.bind(holder)
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


   inner class Holder : EpoxyHolder(){

        lateinit var name: AppCompatTextView
        lateinit var artistname: AppCompatTextView

        lateinit var iv1 : ImageView

        override fun bindView(itemView: View) {

            name = itemView.findViewById(R.id.tv1)
            artistname = itemView.findViewById(R.id.tv2)

            iv1 = itemView.findViewById(R.id.iv1)


        }

    }
}