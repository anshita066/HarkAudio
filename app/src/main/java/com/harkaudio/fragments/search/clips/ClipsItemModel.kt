package com.harkaudio.fragments.search.clips

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.harkaudio.fragments.search.clips.clips_dataclasses.Answer
import com.harkaudio.replica.R

@EpoxyModelClass(layout = R.layout.clip_items)
abstract class ClipsItemModel: EpoxyModelWithHolder<ClipsItemModel.Holder>()  {

    @EpoxyAttribute
    private var answerList: MutableList<Answer> = java.util.ArrayList()

    override fun bind(holder: Holder) {
        super.bind(holder)

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

    class Holder : EpoxyHolder() {
        lateinit var clipTitle: TextView
        lateinit var clipsubtitle: TextView
        lateinit var cliphr: TextView
        lateinit var clipmin: TextView

        lateinit var iv1: ImageView

        override fun bindView(itemView: View) {
            clipTitle = itemView.findViewById(R.id.tv1)
            clipsubtitle = itemView.findViewById(R.id.tv2)
            cliphr = itemView.findViewById(R.id.tv3)
            clipmin = itemView.findViewById(R.id.tv4)

            iv1 = itemView.findViewById(R.id.iv1)
        }

    }
}
