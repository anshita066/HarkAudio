package com.harkaudio.fragments.search

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.harkaudio.fragments.search.clips.ClipsFragment
import com.harkaudio.fragments.search.harklist.HarklistFragment
import com.harkaudio.fragments.search.podcasts.PodcastFragment
import com.harkaudio.fragments.search.profiles.ProfilesFragment

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