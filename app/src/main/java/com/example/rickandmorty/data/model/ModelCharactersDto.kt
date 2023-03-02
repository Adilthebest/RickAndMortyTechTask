package com.example.rickandmorty.data.model

import com.example.rickandmorty.data.mapper.DataMapper
import com.example.rickandmorty.domain.model.modelCharacters.Info
import com.example.rickandmorty.domain.model.modelCharacters.Location
import com.example.rickandmorty.domain.model.modelCharacters.ModelCharacters
import com.example.rickandmorty.domain.model.modelCharacters.Origin
import com.example.rickandmorty.domain.model.modelCharacters.Result

data class ModelCharactersDto(
    val info: InfoDto,
    val results: List<ResultDto>
) : DataMapper<ModelCharacters> {
    override fun toDomain() = ModelCharacters(
        info.toDomain(),
        results.map { it.toDomain() }
    )
}

data class InfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
) : DataMapper<Info> {
    override fun toDomain() = Info(
        count,
        next, pages, prev
    )
}

data class ResultDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CLocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) : DataMapper<Result> {

    override fun toDomain() = Result(
        created,
        episode,
        gender,
        id,
        image,
        location.toDomain(),
        name,
        origin.toDomain(),
        species,
        status,
        type,
        url
    )
}

data class CLocationDto(
    val name: String,
    val url: String
) : DataMapper<Location> {
    override fun toDomain() = Location(
        name, url
    )
}

data class OriginDto(
    val name: String,
    val url: String
) : DataMapper<Origin> {
    override fun toDomain() = Origin(
        name, url
    )
}