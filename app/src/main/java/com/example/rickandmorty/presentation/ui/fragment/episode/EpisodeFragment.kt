package com.example.rickandmorty.presentation.ui.fragment.episode

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.FragmentEpisodeBinding
import com.example.rickandmorty.presentation.ui.base.BaseFragment
import com.example.rickandmorty.presentation.ui.fragment.characters.AllViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class EpisodeFragment : BaseFragment<FragmentEpisodeBinding>() {
    private val viewModel: AllViewModel by sharedViewModel()
    private lateinit var adapter: EpisodeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = EpisodeAdapter()
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentEpisodeBinding {
        return FragmentEpisodeBinding.inflate(layoutInflater)
    }

    override fun initView() {
        binding.episodeRecycler.layoutManager = LinearLayoutManager(context)
        binding.episodeRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.episodeRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }
        getViewModelEpisode()
    }

    override fun initListener() {
        safeFlowGather {
            viewModel.getAllEpisodeSearch.collectLatest {
                getViewModelEpisode()
            }
        }
    }

    fun getViewModelEpisode() {
        viewModel.getEpisodePaging().collectPaging {
            adapter.submitData(it)
        }
    }
}