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
                tagline?.let { result.tagLine = it }
                first_brewed?.let { result.firstBrewed = it }
                image_url?.let { result.imageUrl = it }
                description?.let { result.description = it }
                abv?.let { result.abv = it }
            }
        }
        return result
    }

    fun mapToBeersResult(entity: List<BeerEntity>): List<BeerResult> {
        val beers = mutableListOf<BeerResult>()
        entity.map {beerEntity->
            val beer = BeerResult()
            with(beerEntity) {
                id?.let { beer.id = it }
                name?.let { beer.name = it }
                tagline?.let { beer.tagLine = it }
                first_brewed?.let { beer.firstBrewed = it }
                image_url?.let { beer.imageUrl = it }
                description?.let { beer.description = it }
                abv?.let { beer.abv = it }
            }
            beers.add(beer)
        }
        return beers
    }
}