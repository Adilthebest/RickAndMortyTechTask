package com.example.rickandmorty.domain.model.modelCharacters

data class CharacterFilter(
    var species: String? = null,
    var status: String? = null,
    var gender: String? = null,
)
