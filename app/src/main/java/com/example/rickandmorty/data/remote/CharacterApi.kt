package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.model.EpisodeDto
import com.example.rickandmorty.data.model.LocationDto
import com.timplifier.data.base.BasePagingResponse
import com.timplifier.data.remote.dtos.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {
    @GET("character")
    suspend fun getCharacters(
    ): List<CharacterDto>

    @GET("location")
    suspend fun getLocation(
    ): List<LocationDto>

    @GET("episode")
    suspend fun getEpisode(
    ): List<EpisodeDto>
}