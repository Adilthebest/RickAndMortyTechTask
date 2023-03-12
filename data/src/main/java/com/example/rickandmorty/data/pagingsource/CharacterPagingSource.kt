package com.example.rickandmorty.data.pagingsource

import com.example.rickandmorty.data.base.BasePagingSource
import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domain.model.modelCharacters.Result
import com.example.rickandmorty.data.model.ResultDto

class CharacterPagingSource(
    private val service: ApiService,
    private val name: String?,
    private val status: String?,
    private val gender: String?,
    private val species: String?
) : BasePagingSource<ResultDto, Result>({
    service.getAllCharacters(it, name, status, gender, species)
})
