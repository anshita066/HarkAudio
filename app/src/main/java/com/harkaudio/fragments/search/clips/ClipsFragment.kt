package com.harkaudio.fragments.search.clips

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
import com.harkaudio.fragments.search.SearchFragment
import com.harkaudio.fragments.search.clips.clips_dataclasses.Answer
import com.harkaudio.fragments.search.clips.clips_interfaces.ClipsSearchRepoImpl
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_clips.*

class ClipsFragment : Fragment() {

    private lateinit var myAdapter : ClipsRecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    val clipsSearchRepoImpl = ClipsSearchRepoImpl()

    lateinit var viewModel: ClipsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_clips, container, false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(
            ClipsViewModel::class.java)

        viewModel.clipsItemLiveData.observe(viewLifecycleOwner, Observer {

            myAdapter.updateList(it as ArrayList<Answer>)
            myAdapter.notifyDataSetChanged()
        })

        layoutManager = LinearLayoutManager(context)

        myAdapter = ClipsRecyclerAdapter()

        val recyclerview = rv_title_clips

        recyclerview.layoutManager  = layoutManager

        recyclerview.adapter = myAdapter

        if (parentFragment is SearchFragment){
            (parentFragment as SearchFragment).textChangeLiveData.observe(viewLifecycleOwner, Observer {
                Log.i("ClipFragment", "text updated: $it")

            if(it.isNotBlank()) {
                clipsSearchRepoImpl.fetchSearchClips(0, 20, it, "clips-condensed")
                    .observe(viewLifecycleOwner, Observer {
                        // Logic for UI

                        Log.d("MAIN ACTIVITY", "get title")

                        viewModel.updateClips(it as ArrayList<Answer>)

                    })
            }
            })
        }

    }
}