package com.example.rickandmorty.data.pagingsource

import com.example.rickandmorty.data.base.BasePagingSource
import com.example.rickandmorty.data.model.CLocationDto
import com.example.rickandmorty.data.model.LocationDto
import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domain.model.modelLocation.Location

class LocationPagingSource(
    private val service: ApiService,
    private val name: String?
) : BasePagingSource<LocationDto, Location>({
    service.getAllLocation(it, name)
})
