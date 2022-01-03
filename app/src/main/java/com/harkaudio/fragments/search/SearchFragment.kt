package com.harkaudio.fragments.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.harkaudio.data.Data
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_search)

        val controller = HomeController()
        epoxyview.setController(controller)

        controller.allMessages = Data.messages
        controller.recentlyActive = Data.recentlyActive
    }
}