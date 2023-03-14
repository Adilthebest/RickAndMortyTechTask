package com.example.rickandmorty.presentation.ui.model

import com.example.rickandmorty.domain.model.modelEpisode.Episode

data class EpisodeUi(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)
fun Episode.toUI() = EpisodeUi(
    air_date, characters, created, episode, id, name, url
)
