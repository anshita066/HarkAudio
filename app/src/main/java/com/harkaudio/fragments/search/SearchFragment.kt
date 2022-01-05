package com.harkaudio.fragments.search

import Question
import android.app.DownloadManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.harkaudio.interfaces.SearchRepoImp
import com.harkaudio.fragments.search.recyclerview.RecyclerAdapter
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.activity_main.*


class SearchFragment : Fragment(R.layout.fragment_search) {

    private var titleList = ArrayList<Question> ()

    private lateinit var myAdapter : RecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layoutManager = LinearLayoutManager(context)

        myAdapter = RecyclerAdapter(titleList)
        val recyclerview = R.id.rv_title

//        recyclerview.layoutManager  = layoutManager
//
//        recyclerview.adapter = myAdapter

//        var itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
//        getDrawable(R.drawable.recyclerview_divider)?.let { itemDecoration.setDrawable(it) }
//
//       recyclerview.addItemDecoration(itemDecoration)


        val searchRepoImp = SearchRepoImp()


            searchRepoImp.fetchSearchHarkList(0, 20, "don", "playlist")
                .observe(this, Observer {
                    // Logic for UI

                    Log.d("MAIN ACTIVITY", "get title")

                    titleList = it as ArrayList<Question>
                    myAdapter.setItems(titleList)
                    myAdapter.notifyDataSetChanged()

                })
        }
    }
