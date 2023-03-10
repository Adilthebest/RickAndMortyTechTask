package com.example.rickandmorty.presentation.ui.fragment.characters

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.FragmentCharactersBinding
import com.example.rickandmorty.presentation.ui.base.BaseFragment
import com.example.rickandmorty.presentation.ui.fragment.filter.FilterFragment
import com.example.rickandmorty.presentation.ui.fragment.characters.AllViewModel
import com.example.rickandmorty.presentation.ui.fragment.characters.CharactersAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.merge
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import retrofit2.http.Headers

class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    private val viewModel: AllViewModel by sharedViewModel()

    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = CharactersAdapter()
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentCharactersBinding {
        return FragmentCharactersBinding.inflate(layoutInflater)
    }

    override fun initPaging() {
        binding.charactersRecycler.layoutManager = LinearLayoutManager(context)
        binding.charactersRecycler.adapter = adapter
        adapter.addLoadStateListener { loadStates ->
            binding.charactersRecycler.isVisible = loadStates.refresh is LoadState.NotLoading
            binding.progress.isVisible = loadStates.refresh is LoadState.Loading

        }
        getViewModelCharacter()
    }

    override fun initListener() {
        filterAlert()
        viewFilter()
    }
    private fun viewFilter() {
        safeFlowGather {
            merge(
                viewModel.getAllCharactersSearch,
                viewModel.statusFilter,
                viewModel.genderFilter,
                viewModel.speciesFilter
            ).collectLatest {
                getViewModelCharacter()
            }
        }
    }

    fun getViewModelCharacter() {
        viewModel.getCharacterPaging().collectPaging {
            adapter.submitData(it)
        }
    }

    private fun filterAlert() {
        binding.filter.setOnClickListener {
            val filter = FilterFragment()
            filter.show((activity as AppCompatActivity).supportFragmentManager, "character")
        }
    }

}

