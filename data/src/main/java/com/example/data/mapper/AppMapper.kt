package com.example.data.mapper

import com.example.data.entities.BeerEntity
import com.example.data.entities.ListBeerEntity
import com.example.domain.entities.BeerResult
import com.example.domain.entities.ListBeerResult


class AppMapper {
    fun mapToListBeerResult(entity: ListBeerEntity): ListBeerResult {
        val result = ListBeerResult()
        result.listBeer.add(mapToBeerResult(entity.listBeer))
        return result
    }

    private fun mapToBeerResult(entity: List<BeerEntity>): BeerResult {
        val result = BeerResult()
        entity.map { beerEntity ->
            with(beerEntity) {
                id?.let { result.id = it }
                name?.let { result.name = it }
                tagline?.let { result.tagline = it }
                first_brewed?.let { result.first_brewed = it }
                image_url?.let { result.image_url = it }
                description?.let { result.description = it }
                abv?.let { result.abv = it }
            }
        }
        return result
    }
}