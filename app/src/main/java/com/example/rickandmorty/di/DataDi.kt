package com.example.rickandmorty.di

import com.example.rickandmorty.data.repositoryimpl.RIckAndMortyRepositoryImpl
import com.example.rickandmorty.domain.repository.RickAndMortyRepository
import org.koin.dsl.module

val dataModule = module {
    single<RickAndMortyRepository> { RIckAndMortyRepositoryImpl(get()) }
}