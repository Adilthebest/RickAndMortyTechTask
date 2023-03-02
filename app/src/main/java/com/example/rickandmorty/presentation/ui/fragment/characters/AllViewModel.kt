package com.example.rickandmorty.presentation.ui.fragment.characters

import com.example.rickandmorty.domain.usecase.GetAllCharactersUseCase
import com.example.rickandmorty.domain.usecase.GetAllEpisodeUseCase
import com.example.rickandmorty.domain.usecase.GetAllLocationUseCase
import com.example.rickandmorty.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AllViewModel(
    private val charactersUseCase: GetAllCharactersUseCase,
    private val episodeUseCase: GetAllEpisodeUseCase,
    private val locationUseCase: GetAllLocationUseCase
) : BaseViewModel() {

    private val _getAllCharactersSearch = MutableStateFlow<String?>(null)
    private val _getAllLocationSearch = MutableStateFlow<String?>(null)
    private val _getAllEpisodeSearch = MutableStateFlow<String?>(null)

    val getAllCharactersSearch = _getAllCharactersSearch.asStateFlow()
    val getAllLocationSearch = _getAllCharactersSearch.asStateFlow()
    val getAllEpisodeSearch = _getAllCharactersSearch.asStateFlow()

    private var _statusFilter = MutableStateFlow<String?>(null)
    private val _speciesFilter = MutableStateFlow<String?>(null)
    private val _genderFilter = MutableStateFlow<String?>(null)

    val statusFilter = _statusFilter.asStateFlow()
    val speciesFilter = _speciesFilter.asStateFlow()
    val genderFilter = _genderFilter.asStateFlow()

    fun getLocationPaging() = locationUseCase(_getAllLocationSearch.value).collectPagingRequest {it}

    fun getEpisodePaging() = episodeUseCase(_getAllEpisodeSearch.value).collectPagingRequest { it }

    fun getCharacterPaging() = charactersUseCase(
        _getAllCharactersSearch.value,
        _statusFilter.value,
        _genderFilter.value,
        _speciesFilter.value
    ).collectPagingRequest { it }

    fun filter(status: String?, species: String?, gender: String?) {
        _statusFilter.value = status
        _speciesFilter.value = species
        _genderFilter.value = gender
    }

    fun getAllSearchQuery(newQuery: String?) {
        _getAllEpisodeSearch.value = newQuery
        _getAllLocationSearch.value = newQuery
        _getAllCharactersSearch.value = newQuery
    }
}