package com.harkaudio.fragments.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apidemo.interfaces.SearchRepoImp
import com.harkaudio.RecyclerAdapter
import com.harkaudio.dataclasses.Question
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_harklist.*

class HarklistFragment : Fragment() {

//    private var titleList = ArrayList<Question> ()

    private lateinit var myAdapter : RecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    val searchRepoImp = SearchRepoImp()

    lateinit var viewModel: HarklistViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_harklist, container, false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application)).get(
            HarklistViewModel::class.java)

        viewModel.harklistItemLiveData.observe(this, Observer {

            myAdapter.updateList(it as ArrayList<Question>)
            myAdapter.notifyDataSetChanged()
        })

        layoutManager = LinearLayoutManager(context)

        myAdapter = RecyclerAdapter()
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

                            viewModel.updateHarkList(it as ArrayList<Question>)

                    })
                }
            })
        }
    }
}
