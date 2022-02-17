package com.harkaudio.fragments.search.harklist

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.harkaudio.fragments.search.harklist.harklist_dataclasses.Question
import com.harkaudio.replica.R

@EpoxyModelClass(layout = R.layout.data_items)
abstract class HarklistItemModel : EpoxyModelWithHolder<HarklistItemModel.Holder>() {

    @EpoxyAttribute
    private var questionList: MutableList<Question> = java.util.ArrayList()

    override fun bind(holder: Holder)
    {
        super.bind(holder)

        val quesTitle = questionList[position]
        quesTitle.creator.name

        val title = quesTitle.title ?: "unknown"

        holder.itemTitle.text = title
        holder.creatorName.text = quesTitle.creator.name
        holder.clipCount.text = quesTitle.answerCount.toString()

        var min = (quesTitle.clipRuntime) / 60

        val hr = min / 60

        holder.min.text = min.toString()

        if (min > 60) {
            min -= 60
            holder.min.text = min.toString()

            holder.hrStr.text = "HR"
            holder.hr.text = hr.toString()
        }

        //  holder.contributor.text = quesTitle.sponsor.name

        val creatorImage = String.format(ProductUrl.profileImageFormat, quesTitle.creator.uid)

        val imageHolder = holder.iv6

        Glide.with(holder.itemView)
            .load(creatorImage)
            .into(imageHolder)


        holder.rootLayout.background.colorFilter =
            PorterDuffColorFilter(
                Color.parseColor("#" + quesTitle.color),
                PorterDuff.Mode.SRC_IN
            )

        quesTitle.podcastImagesHash.forEachIndexed { index, url ->

            val imageUrlFormat =
                String.format(ProductUrl.imageUrlFormat300X300, url)

            when (index) {
                0 -> {
                    holder.iv1.visibility = View.VISIBLE
                }
                1 -> {
                    holder.iv2.visibility = View.VISIBLE
                }
                2 -> {
                    holder.iv3.visibility = View.VISIBLE
                }
                3 -> {
                    holder.iv4.visibility = View.VISIBLE
                }
                4 -> {
                    holder.iv5.visibility = View.VISIBLE
                }
            }

            val imageHolder = when (index) {
                0 -> {
                    holder.iv1
                }
                1 -> {
                    holder.iv2
                }
                2 -> {
                    holder.iv3
                }
                3 -> {
                    holder.iv4
                }
                4 -> {
                    holder.iv5
                }
                else -> holder.iv1
            }
            Glide.with(holder)
                .load(imageUrlFormat)
                .into(imageHolder)


        }

    }

    inner class Holder : EpoxyHolder(){

        lateinit var itemTitle: AppCompatTextView
        lateinit var creatorName: AppCompatTextView
        lateinit var contributor: AppCompatTextView
        lateinit var clipCount: AppCompatTextView
        lateinit var hrStr: AppCompatTextView
        lateinit var hr: AppCompatTextView
        lateinit var min: AppCompatTextView

        lateinit var iv1 : ImageView
        lateinit var iv2 : ImageView
        lateinit var iv3 : ImageView
        lateinit var iv4 : ImageView
        lateinit var iv5 : ImageView
        lateinit var iv6 : ImageView

        lateinit var rootLayout : View

        override fun bindView(itemView: View) {

            itemTitle = itemView.findViewById(R.id.tv1)
            creatorName = itemView.findViewById(R.id.tv2)
            contributor = itemView.findViewById(R.id.tv3)
            clipCount = itemView.findViewById(R.id.tv4)
            hrStr = itemView.findViewById(R.id.hr)
            hr = itemView.findViewById(R.id.tv5)
            min = itemView.findViewById(R.id.tv6)

            iv1 = itemView.findViewById(R.id.iv1)
            iv2 = itemView.findViewById(R.id.iv2)
            iv3 = itemView.findViewById(R.id.iv3)
            iv4 = itemView.findViewById(R.id.iv4)
            iv5 = itemView.findViewById(R.id.iv5)
            iv6 = itemView.findViewById(R.id.iv6)

            rootLayout = itemView.findViewById(R.id.rootLayout)
        }

    }
}