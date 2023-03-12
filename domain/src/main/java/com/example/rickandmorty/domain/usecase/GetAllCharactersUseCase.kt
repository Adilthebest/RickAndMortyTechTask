package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.domain.repository.RickAndMortyRepository

class GetAllCharactersUseCase(
    private val rickAndMortyRepository: RickAndMortyRepository
) {
    operator fun invoke(name: String?, status: String?, gender: String?, species: String?) =
        rickAndMortyRepository.getAllCharacters(name, status, gender, species)
}