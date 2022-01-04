package com.harkaudio.fragments.search

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.harkaudio.data.Data
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(R.layout.fragment_search) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = HomeController()
        epoxyview.setController(controller)

        controller.allMessages = Data.messages
        controller.recentlyActive = Data.recentlyActive
    }




    }
