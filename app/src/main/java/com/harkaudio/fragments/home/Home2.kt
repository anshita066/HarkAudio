package com.harkaudio.fragments.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_home2.*
import kotlinx.android.synthetic.main.fragment_home3.*

class Home2 : Fragment(R.layout.fragment_home2) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_home2.setOnClickListener{
            findNavController().navigate(R.id.home3fragment)

        }
    }
}