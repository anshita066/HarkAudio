package com.harkaudio.fragments.search

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyAdapter(
    var context: Context,
    fa: Fragment,
    var totalTabs: Int
) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return totalTabs
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HarklistFragment()
            }
            1 -> {
                ClipsFragment()
            }
            2 -> {
                ProfilesFragment()
            }
            3-> {
                PodcastFragment()
            }
            else -> HarklistFragment()
        }
    }
}