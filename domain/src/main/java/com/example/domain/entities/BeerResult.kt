package com.example.domain.entities

data class ListBeerResult(
    val listBeer: MutableList<BeerResult> = mutableListOf()
)

data class BeerResult(
    var id: Int? = -1,
    var name: String? = null,
    var tagline: String? = null,
    var first_brewed: String? = null,
    var description: String? = null,
    var image_url: String? = null,
    var abv: Float? = 0f
)
