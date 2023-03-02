package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.domain.repository.RickAndMortyRepository

class GetAllEpisodeUseCase(
    private val rickAndMortyRepository: RickAndMortyRepository
) {
    operator fun invoke(name: String?) = rickAndMortyRepository.getAllEpisode(name)
}