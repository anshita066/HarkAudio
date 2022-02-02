package com.harkaudio.fragments.search.podcasts

import Podcast
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.harkaudio.fragments.search.SearchFragment
import com.harkaudio.fragments.search.podcasts.podcast_dataclasses.EpisodeDetail
import com.harkaudio.fragments.search.podcasts.podcast_interfaces.PodcastSearchRepoImp
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_podcasts.*


class PodcastFragment : Fragment() {

    private lateinit var myAdapter : PodcastRecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    private val podcastSearchRepoImp = PodcastSearchRepoImp()

    lateinit var viewModel: PodcastViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_podcasts, container, false
        )
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(
            PodcastViewModel::class.java)

        viewModel.podcastItemLiveData.observe(viewLifecycleOwner, Observer {

            myAdapter.updateList(it as ArrayList<EpisodeDetail>)
            myAdapter.notifyDataSetChanged()
        })

        layoutManager = GridLayoutManager(this.context, 2)

        myAdapter = PodcastRecyclerAdapter()
        val recyclerview = rv_title_podcast

        recyclerview.layoutManager  = layoutManager

        recyclerview.adapter = myAdapter

        if (parentFragment is SearchFragment){
            (parentFragment as SearchFragment).textChangeLiveData.observe(viewLifecycleOwner, Observer {
                Log.i("PodcastFragment", "text updated: $it")

                if(it.isNotBlank()) {
                    podcastSearchRepoImp.fetchPodcastSearch(0, 20, it)
                        .observe(viewLifecycleOwner, Observer {
                            // Logic for UI

                            Log.d("MAIN ACTIVITY", "get title")

                            viewModel.updatePodcast(it as ArrayList<Podcast>)

                        })
                }
            })
        }
    }
}