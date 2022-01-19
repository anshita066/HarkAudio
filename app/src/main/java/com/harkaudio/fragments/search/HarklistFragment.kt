package com.harkaudio.fragments.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apidemo.interfaces.SearchRepoImp
import com.harkaudio.RecyclerAdapter
import com.harkaudio.dataclasses.Question
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_harklist.*
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.ArrayList

class HarklistFragment : Fragment() {

    private var titleList = ArrayList<Question> ()
    private lateinit var myAdapter : RecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    val searchRepoImp = SearchRepoImp()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_harklist, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(context)

        myAdapter = RecyclerAdapter(titleList)
        val recyclerview = rv_title

        recyclerview.layoutManager  = layoutManager

        recyclerview.adapter = myAdapter

        if (parentFragment is SearchFragment){
            (parentFragment as SearchFragment).textChangeLiveData.observe(viewLifecycleOwner, Observer {
                Log.i("HarklistFragment", "text updated: $it")

                if(it.isNotBlank()) {
                    searchRepoImp.fetchSearchHarkList(0, 20, it, "playlist")
                        .observe(this, Observer {
                            // Logic for UI

                        Log.d("MAIN ACTIVITY", "get title")

                        titleList = it as ArrayList<Question>
                        myAdapter.setItems(titleList)
                        myAdapter.notifyDataSetChanged()

                    })
                }
            })
        }
    }
}
