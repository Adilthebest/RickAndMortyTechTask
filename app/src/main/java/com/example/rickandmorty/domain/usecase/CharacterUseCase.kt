package com.example.rickandmorty.domain.usecase

import com.example.rickandmorty.domain.repository.CharacterRepository

class CharacterUseCase(private val repository: CharacterRepository) {
    fun getCharacter(
       ) = repository.getCharacter()
}