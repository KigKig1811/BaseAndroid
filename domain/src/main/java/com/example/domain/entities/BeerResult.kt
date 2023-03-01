package com.example.domain.entities

data class ListBeerResult(
    val listBeer: MutableList<BeerResult> = mutableListOf()
)

data class BeerResult(
    var id: Int? = -1,
    var name: String? = null,
    var tagLine: String? = null,
    var firstBrewed: String? = null,
    var description: String? = null,
    var imageUrl: String? = null,
    var abv: Float? = 0f
)
