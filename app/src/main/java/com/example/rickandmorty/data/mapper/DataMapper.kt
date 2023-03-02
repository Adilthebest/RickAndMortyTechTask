package com.example.rickandmorty.data.mapper

interface DataMapper<T> {
    fun toDomain(): T
}