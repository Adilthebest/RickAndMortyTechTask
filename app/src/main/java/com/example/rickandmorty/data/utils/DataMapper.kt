package com.example.rickandmorty.data.utils

interface DataMapper<T> {
    fun toDomain(): T
}