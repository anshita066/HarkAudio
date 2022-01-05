package com.harkaudio.fragments.search.epoxy

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.harkaudio.fragments.search.data.Profile
import com.harkaudio.replica.R

@EpoxyModelClass(layout = R.layout.fragment_search3)
abstract class RecentlyActiveItemModel : EpoxyModelWithHolder<RecentlyActiveItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var profile: Profile

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(profile) {
            holder.profileName.text = name
            holder.lastSeen.text = lastSeen
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var profileImage: ImageView
        lateinit var profileName: AppCompatTextView
        lateinit var lastSeen: AppCompatTextView

        override fun bindView(itemView: View) {
            profileImage = itemView.findViewById(R.id.search3img1)
            profileName = itemView.findViewById(R.id.search3tv1)
            lastSeen = itemView.findViewById(R.id.search3tv2)
        }
    }
}