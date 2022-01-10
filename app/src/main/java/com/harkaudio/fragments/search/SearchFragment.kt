package com.harkaudio.fragments.search

import android.annotation.SuppressLint
import android.app.appsearch.SearchResult
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.CheckResult
import androidx.appcompat.widget.SearchView
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.harkaudio.replica.R
import com.jakewharton.rxbinding2.widget.textChanges
import io.reactivex.BackpressureStrategy
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import java.util.*
import java.util.concurrent.Flow
import java.util.concurrent.TimeUnit

class SearchFragment : Fragment(R.layout.fragment_search) {


    lateinit var onTextChange: (String) -> Unit


    private val disposable = CompositeDisposable()
    private val _textInput = BehaviorSubject.create<String>()
    private val textInput = _textInput.toFlowable(BackpressureStrategy.LATEST)

    lateinit var tab: TabLayout
    lateinit var viewPagr: ViewPager

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onTextChange = debounce(
            1000L,
            viewLifecycleOwner.lifecycleScope, this::textChange
        )


        editsearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                editable?.toString()?.let { onTextChange(it) }
            }

            override fun beforeTextChanged(charSeq: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(charSeq: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        disposable.add(
            textInput
                .debounce(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    tv_display.text = tv_display.text.toString() + "\n" + it
                }
        )


        tab = tabLayout

        tabLayout.addTab(tabLayout.newTab().setText("Harklist"))
        tabLayout.addTab(tabLayout.newTab().setText("Clips"))
        tabLayout.addTab(tabLayout.newTab().setText("Profiles"))
        tabLayout.addTab(tabLayout.newTab().setText("Podcast"))

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = MyAdapter(
            activity!!.applicationContext, this,
            tabLayout.tabCount
        )
        viewPager.adapter = adapter
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })


    }

    fun <T> debounce(
        waitMs: Long = 300L,
        coroutineScope: CoroutineScope,
        destinationFunction: (T) -> Unit
    ): (T) -> Unit {
        var debounceJob: Job? = null
        return { param: T ->
            debounceJob?.cancel()
            debounceJob = coroutineScope.launch {
                delay(waitMs)
                if (param is String) {
                    if (param.isNotBlank()) {
//                        setScreen(SearchViewModel.ExploreScreenType.Tab)
//                        rightButton.setViewVisibility(true)
                    }
                }
                destinationFunction(param)
            }
        }
    }

    private fun textChange(text: String) {
//        textChangeLiveData.value = text
        Log.i("SearchFragment","text:$text" )
    }
}

