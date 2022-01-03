package com.harkaudio.fragments.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

                homebtn1.setOnClickListener {
                    findNavController().navigate(R.id.home1fragment)
                }
                homebtn2.setOnClickListener{
                    findNavController().navigate(R.id.home2fragment)
                }
                homebtn3.setOnClickListener{
                    findNavController().navigate(R.id.home3fragment)
                }
    }
}