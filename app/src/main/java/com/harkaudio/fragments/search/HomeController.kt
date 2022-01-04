package com.harkaudio.fragments.search

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.carousel
import com.harkaudio.data.Message
import com.harkaudio.data.Profile

class HomeController : EpoxyController() {


    var recentlyActive: List<Profile> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    var allMessages: List<Message> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        headerItem {
            id("recently_active")
            title("Recently Active")
        }
        val models = recentlyActive.map {
            RecentlyActiveItemModel_()
                .id(it.id)
                .profile(it)
        }
        carousel {
            id("recent")
            padding(Carousel.Padding.dp(0, 4, 0, 16, 8))
            hasFixedSize(true)
            models(models)
        }
        headerItem {
            id("all_messages")
            title("All Messages")
        }
//        allMessages.forEach {
//            search1 {
//                id(it.id)
//                message(it)
//            }
//
//        }

    }
}
