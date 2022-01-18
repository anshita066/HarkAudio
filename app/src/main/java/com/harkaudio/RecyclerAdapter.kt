package com.harkaudio

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
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.harkaudio.ProductUrl
import com.harkaudio.ProductUrl.profileImageFormat
import com.harkaudio.dataclasses.Question

import com.harkaudio.replica.R
import com.harkaudio.replica.databinding.ActivityMainBinding.inflate

class RecyclerAdapter(
    private var titleList: MutableList<Question>,

    ) : Filterable, RecyclerView.Adapter<RecyclerAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.data_items, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = titleList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val quesTitle = titleList[position]
        quesTitle.creator.name

        val title = quesTitle.title ?: "unknown"

        holder.itemTitle.text = title
        holder.creatorName.text = quesTitle.creator.name
        holder.clipCount.text = quesTitle.answerCount.toString()

        var min = (quesTitle.clipRuntime)/60

        val hr = min/60

        holder.min.text = min.toString()

        if (min > 60){
            min -= 60
            holder.min.text = min.toString()

            holder.hrStr.text = "HR"
            holder.hr.text = hr.toString()
        }

      //  holder.contributor.text = quesTitle.sponsor.name

            val creatorImage = String.format(profileImageFormat,  quesTitle.creator.uid )

            val imageHolder = holder.iv6

            Glide.with(holder.itemView)
                .load(creatorImage)
                .into(imageHolder)


       holder.rootLayout.background.colorFilter =
            PorterDuffColorFilter(
                Color.parseColor("#"+quesTitle.color),
                PorterDuff.Mode.SRC_IN
            )

        quesTitle.podcastImagesHash.forEachIndexed{ index, url->

            val imageUrlFormat =
                String.format(ProductUrl.imageUrlFormat300X300, url)

            when (index){
                0->{    holder.iv1.visibility = View.VISIBLE     }
                1->{    holder.iv2.visibility = View.VISIBLE     }
                2->{    holder.iv3.visibility = View.VISIBLE     }
                3->{    holder.iv4.visibility = View.VISIBLE     }
                4->{    holder.iv5.visibility = View.VISIBLE     }
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
            Glide.with(holder.itemView)
                .load(imageUrlFormat)
                .into(imageHolder)


        }


    }

    fun setItems(titleList: ArrayList<Question>) {

        this.titleList = titleList
    }


    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTitle: TextView = itemView.findViewById(R.id.tv1)
        var creatorName: TextView = itemView.findViewById(R.id.tv2)
        var contributor: TextView = itemView.findViewById(R.id.tv3)
        var clipCount: TextView = itemView.findViewById(R.id.tv4)
        var hrStr : TextView = itemView.findViewById(R.id.hr)
        var hr: TextView = itemView.findViewById(R.id.tv5)
        var min: TextView = itemView.findViewById(R.id.tv6)

        var iv1: ImageView = itemView.findViewById(R.id.iv1)
        var iv2: ImageView = itemView.findViewById(R.id.iv2)
        var iv3: ImageView = itemView.findViewById(R.id.iv3)
        var iv4: ImageView = itemView.findViewById(R.id.iv4)
        var iv5: ImageView = itemView.findViewById(R.id.iv5)
        var iv6: ImageView = itemView.findViewById(R.id.iv6)

        var rootLayout: View = itemView.findViewById(R.id.rootLayout)

    }

    override fun getFilter(): Filter {
        TODO("Not yet implemented")
    }

//    private fun filterList( titleList: fi){
//
//    }

}







