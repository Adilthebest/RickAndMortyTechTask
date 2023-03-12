package com.example.rickandmorty.domain.model.modelLocation

data class DModelLocation(
    val info: InfoLocation,
    val results: List<Location>
)

data class InfoLocation(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class Location(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)