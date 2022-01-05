package com.harkaudio.fragments.search.epoxy

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.harkaudio.fragments.search.data.Message
import com.harkaudio.replica.R

//MESSAGE
@EpoxyModelClass(layout = R.layout.fragment_search)
abstract class Search1 : EpoxyModelWithHolder<Search1.Holder>() {

    @EpoxyAttribute
    lateinit var message: Message

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(message) {
            holder.title.text = username
            holder.content.text = content
        }
    }

    class Holder : EpoxyHolder() {

        lateinit var profileImage: ImageView
        lateinit var title: AppCompatTextView
        lateinit var content: AppCompatTextView

        override fun bindView(itemView: View) {
            profileImage = itemView.findViewById(R.id.searchimg1)
            title = itemView.findViewById(R.id.searchtv1)
            content = itemView.findViewById(R.id.searchtv2)
        }
    }
}
