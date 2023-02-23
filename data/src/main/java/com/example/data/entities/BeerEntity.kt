package com.example.data.entities


data class ListBeerEntity(
    var listBeer: MutableList<BeerEntity> = mutableListOf()
) {
    companion object {
        fun create(map: Map<String, Any?>): ListBeerEntity {
            val listBeerEntity = ListBeerEntity()
            map.map {
                val value = it.value.toString()
                val dataList = value as List<Map<String, Any?>>
                listBeerEntity.listBeer = dataList.map { map ->
                    BeerEntity.create(map)
                }.toMutableList()
            }
            return listBeerEntity
        }
    }
}

data class BeerEntity(
    var id: Int? = -1,
    var name: String? = null,
    var tagline: String? = null,
    var first_brewed: String? = null,
    var description: String? = null,
    var image_url: String? = null,
    var abv: Float? = 0f
) {
    companion object {
        fun create(map: Map<String, Any?>): BeerEntity {
            val beerEntity = BeerEntity()
            map.map {
                val value = it.value.toString()
                when (it.key) {
                    "id" -> beerEntity.id = value.toInt()
                    "name" -> beerEntity.name = value
                    "tagline" -> beerEntity.tagline = value
                    "first_brewed" -> beerEntity.first_brewed = value
                    "description" -> beerEntity.description = value
                    "images_url" -> beerEntity.image_url = value
                    "abv" -> beerEntity.abv = value.toFloat()
                }
            }
            return beerEntity
        }
    }
}
