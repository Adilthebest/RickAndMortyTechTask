package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.base.BaseRepositor
import com.example.rickandmorty.data.remote.CharacterApi
import com.example.rickandmorty.domain.model.CharacterModel
import com.example.rickandmorty.domain.model.LocationModel
import com.example.rickandmorty.domain.repository.CharacterRepository
import com.example.rickandmorty.domain.utils.Resourse
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl(private val api:CharacterApi):CharacterRepository ,BaseRepositor(){
    override fun getCharacter(

    ): Flow<Resourse<List<CharacterModel>>> = doReguest {
        api.getCharacters().map { it.toDomain() }
    }

    override fun getLocation(): Flow<Resourse<List<LocationModel>>> = doReguest{
        api.getLocation().map { it.toDomain() }
    }

}