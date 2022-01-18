package com.harkaudio.fragments.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apidemo.interfaces.SearchRepoImp
import com.google.android.material.tabs.TabLayout
import com.harkaudio.RecyclerAdapter
import com.harkaudio.SearchFragmentViewModel
import com.harkaudio.dataclasses.Question
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.*
import java.util.*

class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var viewModel: SearchFragmentViewModel

    private var titleList = ArrayList<Question> ()

    private lateinit var myAdapter : RecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null

    lateinit var onTextChange: (String) -> Unit
    val textChangeLiveData = MutableLiveData<String>()

    private var _binding: HarklistFragment? = null

    lateinit var tab: TabLayout

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this)[SearchFragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

/*        btn.setOnClickListener {
            viewModel.selectedItem("this is new item")
        }
*/
        layoutManager = LinearLayoutManager(context)

        myAdapter = RecyclerAdapter(titleList)
        val recyclerview = rv_title

        recyclerview.layoutManager  = layoutManager

        recyclerview.adapter = myAdapter

        onTextChange = debounce(
            1000L,
            viewLifecycleOwner.lifecycleScope, this::textChange
        )


        // search repo impl

        val searchRepoImp = SearchRepoImp()

        searchRepoImp.fetchSearchHarkList(0, 20, "don", "playlist")
            .observe(this, Observer {
                // Logic for UI

                Log.d("MAIN ACTIVITY","get title")

                titleList = it as ArrayList<Question>
                myAdapter.setItems(titleList)
                myAdapter.notifyDataSetChanged()

            })


        //search box text change listener

        editsearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                editable?.toString()?.let { onTextChange(it) }
            }

            override fun beforeTextChanged(charSeq: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(charSeq: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })



        //search button

        searchicon.setOnClickListener {
            search(it)
        }


        // tab layout and page loader

        tab = tabLayout

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


    // search debounce

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
        textChangeLiveData.value = text
        Log.i("SearchFragment","text:$text" )
    }

    @SuppressLint("ResourceType")
   private fun search(search: View){
        if(editsearch!=null){

            editsearch.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    searchRepoImp.fetchSearchHarkList(
                        0,
                        20,
                        "don",
                        "playlist"
                    )
                        .observe(this@SearchFragment, Observer {
                            // Logic for UI

                            Log.d("MAIN ACTIVITY", "get title")

                            titleList = it as ArrayList<Question>
                            myAdapter.setItems(titleList)
                            myAdapter.notifyDataSetChanged()

                        })
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    searchRepoImp.fetchSearchHarkList(
                        0,
                        20,
                        "don",
                        "playlist"
                    )
                        .observe(this@SearchFragment, Observer {
                            // Logic for UI

                            Log.d("MAIN ACTIVITY", "get title")

                            titleList = it as ArrayList<Question>
                            myAdapter.setItems(titleList)
                            myAdapter.notifyDataSetChanged()

                        })
                }

                val searchRepoImp = SearchRepoImp()

                override fun afterTextChanged(editable: Editable?) {
                    editable?.toString()?.let { onTextChange(it) }

                    if (editable!!.isNotEmpty()) {
                        editable.forEach {
                            if (it.lowercase().contains(editable)) {

                                searchRepoImp.fetchSearchHarkList(
                                    0,
                                    20,
                                    editable.toString(),
                                    "playlist"
                                )
                                    .observe(this@SearchFragment, Observer {
                                        // Logic for UI

                                        Log.d("MAIN ACTIVITY", "get title")

                                        titleList = it as ArrayList<Question>
                                        myAdapter.setItems(titleList)
                                        myAdapter.notifyDataSetChanged()

                                    })
                            }
                            else{
                                searchRepoImp.fetchSearchHarkList(
                                    0,
                                    20,
                                    "don",
                                    "playlist"
                                )
                                    .observe(this@SearchFragment, Observer {
                                        // Logic for UI

                                        Log.d("MAIN ACTIVITY", "get title")

                                        titleList = it as ArrayList<Question>
                                        myAdapter.setItems(titleList)
                                        myAdapter.notifyDataSetChanged()

                                    })
                            }
                        }

                    }
                }
            })
            }

    }
}

