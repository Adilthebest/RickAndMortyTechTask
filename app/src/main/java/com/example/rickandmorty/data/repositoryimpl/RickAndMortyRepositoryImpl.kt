package com.example.rickandmorty.data.repositoryimpl

import androidx.paging.PagingData
import com.example.rickandmorty.data.base.BaseRepository
import com.example.rickandmorty.data.pagingsource.CharacterPagingSource
import com.example.rickandmorty.data.pagingsource.EpisodePagingSource
import com.example.rickandmorty.data.pagingsource.LocationPagingSource
import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domain.model.modelEpisode.Episode
import com.example.rickandmorty.domain.model.modelCharacters.Result
import com.example.rickandmorty.domain.model.modelLocation.Location
import com.example.rickandmorty.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow

class RickAndMortyRepositoryImpl(private val apiService: ApiService) : RickAndMortyRepository,
    BaseRepository() {
    override fun getAllCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<PagingData<Result>> {
        return doPagingRequest(CharacterPagingSource(apiService, name, status, gender, species))
    }

    override fun getAllEpisode(name: String?): Flow<PagingData<Episode>> {
        return doPagingRequest(EpisodePagingSource(apiService, name))
    }

    override fun getAllLocation(name: String?): Flow<PagingData<Location>> {
        return doPagingRequest(LocationPagingSource(apiService, name))
    }

}