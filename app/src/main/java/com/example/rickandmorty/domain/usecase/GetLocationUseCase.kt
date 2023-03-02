package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.domain.repository.CharacterRepository

class GetLocationUseCase(private val repository: CharacterRepository) {
    fun getLocation() = repository.getLocation()
}