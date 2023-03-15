package com.example.baseandroid.feature.beer


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.common.base.BaseViewModel
import com.example.domain.entities.BeerResult
import com.example.domain.entities.Event
import com.example.domain.entities.ListBeerResult
import com.example.domain.usecases.AppUseCase

typealias EventListBeer = Event<List<BeerResult>>

class BeerViewModel(
    private val beerUseCase: AppUseCase
) : BaseViewModel() {

    private val _listBeerLiveData: MutableLiveData<EventListBeer> = MutableLiveData()
    val listBeerLiveData: LiveData<EventListBeer> = _listBeerLiveData

    var listBeer = mutableListOf<BeerResult>()

    fun getBeers() {
        val disposable = beerUseCase.requestGetBeer(

        ).subscribe { response ->
            _listBeerLiveData.value = Event(response)
        }
        addDisposable(disposable)
    }


}