package com.example.rickandmorty.data.repositoryimpl

import com.example.rickandmorty.data.base.BaseRepository
import com.example.rickandmorty.data.pagingsource.CharacterPagingSource
import com.example.rickandmorty.data.pagingsource.EpisodePagingSource
import com.example.rickandmorty.data.pagingsource.LocationPagingSource
import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domain.repository.RickAndMortyRepository

class RIckAndMortyRepositoryImpl(private val apiService: ApiService) : RickAndMortyRepository,
    BaseRepository() {
    override fun getAllCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ) = doPagingRequest(CharacterPagingSource(apiService, name, status, gender, species))


    override fun getAllEpisode(name: String?) =
        doPagingRequest(EpisodePagingSource(apiService, name))


    override fun getAllLocation(name: String?) =
        doPagingRequest(LocationPagingSource(apiService, name))


}