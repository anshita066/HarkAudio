package com.harkaudio.fragments.library


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_library1.*


class Library1 : Fragment(R.layout.fragment_library1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn1_library1.setOnClickListener {
            findNavController().navigate(R.id.libraryFragment)
        }
    }
}