package com.example.rickandmorty.data.model


import com.example.rickandmorty.data.utils.DataMapper
import com.google.gson.annotations.SerializedName
import com.example.rickandmorty.domain.model.OriginModel

data class OriginDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) : DataMapper<OriginModel> {
    override fun toDomain() = OriginModel(name, url)
}

fun OriginModel.toData() = OriginDto(name, url)
