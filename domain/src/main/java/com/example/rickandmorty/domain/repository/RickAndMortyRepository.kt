package com.example.rickandmorty.domain.repository
import androidx.paging.PagingData
import com.example.rickandmorty.domain.model.modelEpisode.Episode
import com.example.rickandmorty.domain.model.modelLocation.Location
import com.example.rickandmorty.domain.model.modelCharacters.Result
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getAllCharacters(
        name: String?,
        status: String?,
        gender: String?,
        species: String?
    ): Flow<PagingData<Result>>

    fun getAllEpisode(name: String?): Flow<PagingData<Episode>>
    fun getAllLocation(name: String?): Flow<PagingData<Location>>

}