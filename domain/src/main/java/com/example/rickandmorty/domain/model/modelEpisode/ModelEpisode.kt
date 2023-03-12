package com.example.rickandmorty.domain.model.modelEpisode

data class ModelEpisode(
    val info: InfoEpisode,
    val results: List<Episode>
)

data class InfoEpisode(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class Episode(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)

