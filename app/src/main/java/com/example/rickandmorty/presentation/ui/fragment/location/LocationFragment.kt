package com.example.rickandmorty.presentation.ui.fragment.location

import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.FragmentLocationBinding
import com.example.rickandmorty.presentation.ui.base.BaseFragment
import com.example.rickandmorty.presentation.ui.fragment.characters.AllViewModel
import com.example.rickandmorty.presentation.ui.fragment.location.LocationAdapter
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class LocationFragment : BaseFragment<FragmentLocationBinding>() {
    private val viewModel: AllViewModel by sharedViewModel()
    private lateinit var adapter: LocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = LocationAdapter()
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentLocationBinding {
        return FragmentLocationBinding.inflate(layoutInflater)
    }

    override fun initListener() {
        binding.charactersRecycler.layoutManager = LinearLayoutManager(context)
        binding.charactersRecycler.adapter = adapter

        adapter.addLoadStateListener { loadStates ->
            binding.charactersRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
        }
        getViewModelLocation()
    }

    override fun initView() {
        safeFlowGather {
            viewModel.getAllLocationSearch.collectLatest {
                getViewModelLocation()
            }
        }
    }

    fun getViewModelLocation() {
        viewModel.getLocationPaging().collectPaging {
            adapter.submitData(it)
        }
    }
}