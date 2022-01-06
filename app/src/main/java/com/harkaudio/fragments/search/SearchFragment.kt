package com.harkaudio.fragments.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.harkaudio.replica.R
import com.jakewharton.rxbinding2.widget.textChanges
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment(R.layout.fragment_search) {

    lateinit var tab: TabLayout
    lateinit var viewPagr: ViewPager
    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        editsearch.textChanges()
            .skipInitialValue()
            .debounce(500, TimeUnit.MILLISECONDS)
//            .doOnNext {
//                if (it.trim().toString().length >= 3)
//                    progressLiveData.postValue(View.VISIBLE)
//            }
            .filter {
                it.trim().toString().length >= 3
            }
//            .flatMapSingle {
//                // Perform API operation
//                fetchSearchResults(it.trim().toString())
//            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
//            .subscribe({
//                progressLiveData.postValue(View.GONE)
//                // subscribe to the success here
//            }, {
//                progressLiveData.postValue(View.GONE)
//                // subscribe to the failure here
//            })



        tab = tabLayout
        viewPagr= viewPager
        tabLayout.addTab(tabLayout.newTab().setText("Harklist"))
        tabLayout.addTab(tabLayout.newTab().setText("Clips"))
        tabLayout.addTab(tabLayout.newTab().setText("Profiles"))
        tabLayout.addTab(tabLayout.newTab().setText("Podcast"))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(activity!!.applicationContext, activity!!.supportFragmentManager,
                            tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position

            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }


    }
