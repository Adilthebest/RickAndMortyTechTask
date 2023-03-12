package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.base.BasePagingResponse
import com.example.rickandmorty.data.model.EpisodeDto
import com.example.rickandmorty.data.model.LocationDto
import com.example.rickandmorty.data.model.ResultDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int,
        @Query("name") name: String?,
        @Query("status") status: String?,
        @Query("gender") gender: String?,
        @Query("species") species: String?,
    ): BasePagingResponse<ResultDto>

    @GET("episode")
    suspend fun getAllEpisode(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): BasePagingResponse<EpisodeDto>

    @GET("location")
    suspend fun getAllLocation(
        @Query("page") page: Int,
        @Query("name") name: String?
    ): BasePagingResponse<LocationDto>
}


