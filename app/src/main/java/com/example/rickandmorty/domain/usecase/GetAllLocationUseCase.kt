package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.domain.repository.RickAndMortyRepository

class GetAllLocationUseCase(
    private val rickAndMortyRepository: RickAndMortyRepository
) {
    operator fun invoke(name: String?) = rickAndMortyRepository.getAllLocation(name)
}