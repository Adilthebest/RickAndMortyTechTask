package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.domain.utils.Resourse
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.model.LocationModel
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharacter(): Flow<Resourse<List<CharacterModel>>>
    fun getLocation(): Flow<Resourse<List<LocationModel>>>
}