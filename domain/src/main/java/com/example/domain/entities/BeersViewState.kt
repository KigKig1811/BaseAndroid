package com.example.domain.entities


data class BeersViewState(val isLoading: Boolean,
                          val error: Error?,
                          val beers: List<BeerResult>?)