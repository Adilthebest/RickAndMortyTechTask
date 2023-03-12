package com.example.rickandmorty.presentation.ui.fragment.characters.splash

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.FragmentSplashBinding
import com.example.rickandmorty.presentation.ui.base.BaseFragment
import com.example.rickandmorty.presentation.ui.fragment.characters.AllViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    private val viewModel: AllViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initView() {
        viewModel.getCharacterPaging()
        viewModel.getEpisodePaging()
        viewModel.getLocationPaging()
        activity?.actionBar?.hide()
        Handler(Looper.getMainLooper()).postDelayed ({
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        } ,1500)

    }
}