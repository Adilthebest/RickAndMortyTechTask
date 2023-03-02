package com.example.rickandmorty.data.model


import com.example.rickandmorty.data.utils.DataMapper
import com.google.gson.annotations.SerializedName
import com.example.rickandmorty.domain.model.LocationModel

data class LocationDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) : DataMapper<LocationModel> {
    override fun toDomain() = LocationModel(name, url)
}

fun LocationModel.toData() = LocationDto(name, url)