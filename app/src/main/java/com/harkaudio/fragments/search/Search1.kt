package com.harkaudio.fragments.search


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search1.*

class Search1 : Fragment(R.layout.fragment_search1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1_search1.setOnClickListener {
            findNavController().navigate(R.id.searchFragment)
        }
    }
}