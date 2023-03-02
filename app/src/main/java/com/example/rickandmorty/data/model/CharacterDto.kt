package com.timplifier.data.remote.dtos


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty.data.model.LocationDto
import com.example.rickandmorty.data.model.OriginDto
import com.example.rickandmorty.data.model.toData
import com.example.rickandmorty.data.utils.DataMapper
import com.google.gson.annotations.SerializedName
import com.example.rickandmorty.domain.model.CharacterModel

@Entity
data class CharacterDto(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: OriginDto,
    @SerializedName("location")
    val location: LocationDto,
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
) : DataMapper<CharacterModel> {

    override fun toDomain() = CharacterModel(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin.toDomain(),
        location.toDomain(),
        image,
        episode,
        url,
        created
    )
}

fun CharacterModel.toData() = CharacterDto(
    id,
    name,
    status,
    species,
    type,
    gender,
    origin.toData(),
    location.toData(),
    image,
    episode,
    url,
    created
)