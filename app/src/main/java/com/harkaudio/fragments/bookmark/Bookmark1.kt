package com.harkaudio.fragments.bookmark

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_bookmark.*
import kotlinx.android.synthetic.main.fragment_bookmark1.*
import kotlinx.android.synthetic.main.fragment_library1.*


class Bookmark1 : Fragment(R.layout.fragment_bookmark1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1_bookmark1.setOnClickListener {
            findNavController().navigate(R.id.bookmarkFragment)
        }
    }
}