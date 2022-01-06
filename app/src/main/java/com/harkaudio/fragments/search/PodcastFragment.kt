package com.harkaudio.fragments.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.harkaudio.replica.R

class PodcastFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_podcasts, container, false
        )
    }
    // Here "layout_login" is a name of layout file
    // created for LoginFragment
}