package com.harkaudio.fragments.search.profiles

import Member
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.harkaudio.fragments.search.SearchFragment
import com.harkaudio.fragments.search.clips.ClipsRecyclerAdapter
import com.harkaudio.fragments.search.clips.ClipsViewModel
import com.harkaudio.fragments.search.clips.clips_dataclasses.Answer
import com.harkaudio.fragments.search.clips.clips_interfaces.ClipsSearchRepoImpl
import com.harkaudio.fragments.search.profiles.profiles_interfaces.ProfilesSearchRepoImp
import com.harkaudio.replica.R
import kotlinx.android.synthetic.main.fragment_clips.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_profiles.*

class ProfilesFragment : Fragment() {

    private lateinit var myAdapter : ProfilesRecyclerAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null
    val clipsSearchRepoImpl = ProfilesSearchRepoImp()

    lateinit var viewModel: ProfilesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_profiles, container, false
        )

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(
            ProfilesViewModel::class.java)

        viewModel.profilesItemLiveData.observe(viewLifecycleOwner, Observer {

            myAdapter.updateList(it as ArrayList<Member>)
            myAdapter.notifyDataSetChanged()
        })

        layoutManager = LinearLayoutManager(context)

        myAdapter = ProfilesRecyclerAdapter()

        val recyclerview = rv_title_profiles

        recyclerview.layoutManager  = layoutManager

        recyclerview.adapter = myAdapter

        recyclerview.apply {
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }
        if (parentFragment is SearchFragment){
            (parentFragment as SearchFragment).textChangeLiveData.observe(viewLifecycleOwner, Observer {
                Log.i("ClipFragment", "text updated: $it")

                if(it.isNotBlank()) {
                    clipsSearchRepoImpl.fetchProfilesSearch(0, 20, it, "members")
                        .observe(viewLifecycleOwner, Observer {
                            // Logic for UI

                            Log.d("MAIN ACTIVITY", "get title")

                            viewModel.updateProfiles(it as ArrayList<Member>)

                        })
                }
            })
        }

    }
}