package com.harkaudio.fragments.search.profiles

import Member
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.harkaudio.fragments.search.harklist.HarklistItemModel
import com.harkaudio.replica.R

@EpoxyModelClass(layout = R.layout.profile_items)
abstract class ProfilesItemModel : EpoxyModelWithHolder<ProfilesItemModel.Holder>(){

    @EpoxyAttribute
    private var memberList: MutableList<Member> = java.util.ArrayList()

    override fun bind(holder: Holder) {
        super.bind(holder)

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

    class Holder : EpoxyHolder(){

        lateinit var heading1: AppCompatTextView
        lateinit var heading2: AppCompatTextView
        lateinit var heading3: AppCompatTextView
        lateinit var heading4: AppCompatTextView

        lateinit var iv1 : ImageView

        override fun bindView(itemView: View) {

            heading1 = itemView.findViewById(R.id.tv1)
            heading2 = itemView.findViewById(R.id.tv2)
            heading3 = itemView.findViewById(R.id.tv3)
            heading4 = itemView.findViewById(R.id.tv4)


            iv1 = itemView.findViewById(R.id.iv1)


        }

    }


}