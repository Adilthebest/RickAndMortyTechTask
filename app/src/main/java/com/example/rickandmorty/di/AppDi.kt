package com.example.rickandmorty.di

import com.example.rickandmorty.presentation.ui.fragment.characters.AllViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        AllViewModel(get(),get(),get())
    }
}