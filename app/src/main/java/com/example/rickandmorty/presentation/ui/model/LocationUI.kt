package com.example.rickandmorty.presentation.ui.model

import com.example.rickandmorty.domain.model.modelLocation.Location

data class LocationUI(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)

fun Location.toUI() = LocationUI(
    created, dimension, id, name, residents, type, url
)