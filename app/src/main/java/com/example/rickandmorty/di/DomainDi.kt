package com.example.rickandmorty.di

import com.example.rickandmorty.domain.usecase.GetAllCharactersUseCase
import com.example.rickandmorty.domain.usecase.GetAllEpisodeUseCase
import com.example.rickandmorty.domain.usecase.GetAllLocationUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetAllCharactersUseCase(rickAndMortyRepository = get()) }
    factory { GetAllEpisodeUseCase(rickAndMortyRepository = get()) }
    factory { GetAllLocationUseCase(rickAndMortyRepository = get()) }

}