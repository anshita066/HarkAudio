package com.harkaudio.fragments.search.harklist

import Member
import com.airbnb.epoxy.EpoxyController

class HarklistEpoxyController : EpoxyController() {

    var harklist = ArrayList<Member>()
        set(value) {
            field = value
            requestModelBuild()
        }

//    var isLoading : Boolean = true
//    set(value) {
//        field = value
//        if (field){
//            requestModelBuild()
//        }
//    }


    override fun buildModels() {
        //add header model
        //add image model
    }
}