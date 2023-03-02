package com.example.rickandmorty.presentation.ui.fragment.home

import android.view.LayoutInflater
import android.widget.SearchView
import com.example.rickandmorty.databinding.FragmentHomeBinding
import com.example.rickandmorty.presentation.ui.base.BaseFragment
import com.example.rickandmorty.presentation.ui.fragment.characters.AllViewModel
import com.example.rickandmorty.presentation.ui.utils.viewpager.ViewPagerAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel: AllViewModel by sharedViewModel()
    override fun inflate(layoutInflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(requireActivity().supportFragmentManager)

        binding.searchId.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?) = viewModel.getAllSearchQuery(p0).run { true }
        })
    }
}