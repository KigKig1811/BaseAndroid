package com.example.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.HttpException
import com.example.domain.entities.Event
import com.example.domain.entities.MemCache
import com.example.domain.entities.TokenStatusThrowable
import com.example.domain.enumApp.TokenStatusEnum
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import org.koin.java.KoinJavaComponent.inject
import java.net.ConnectException
import java.net.UnknownHostException


open class BaseViewModel: ViewModel()  {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val memCache: MemCache by inject(MemCache::class.java)

    private val _lostInternetLiveData: MutableLiveData<Event<String>> = MutableLiveData()
    val lostInternetLiveData: LiveData<Event<String>> = _lostInternetLiveData

    private val _errorLiveData: MutableLiveData<Event<String>> = MutableLiveData()
    val errorLiveData: LiveData<Event<String>> = _errorLiveData

    private val _backToLoginScreenLiveData: MutableLiveData<Event<TimeOutModel>> = MutableLiveData()
    val backToLoginScreenLiveData: LiveData<Event<TimeOutModel>> = _backToLoginScreenLiveData

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        clearDisposables()
    }

    private fun clearDisposables() {
        compositeDisposable.clear()
    }

    protected fun handleNetworkError(e: Throwable, requestCode: Int=101) {
        //Todo pass context into this File.
        when (e) {
            is TokenStatusThrowable -> {
                if (e.tokenStatusEnum == TokenStatusEnum.SESSION_TIME_OUT || e.tokenStatusEnum == TokenStatusEnum.TOKEN_NOT_FOUND) {
                    _backToLoginScreenLiveData.value = Event(TimeOutModel(e.message?:"", requestCode))
                } else {
                    val message = if (e.message.isNullOrBlank())
                        "Failed To Connect To server"
                    else
                        e.message?:""
                    _errorLiveData.value = Event(message)
                }
            }
            is HttpException, is UnknownHostException, is ConnectException -> {
                _lostInternetLiveData.value = Event("Failed To Connect To server")
            }
            else -> {
                e.cause?.let {
                    _errorLiveData.value = Event(it.message?:"")
                }?: kotlin.run {
                    _errorLiveData.value = Event(e.message?:"")
                }
//                _errorLiveData.value = Event("System Error. Please try again later")
//                e.message?.let {message ->
//                    if(message.contains("Apitest.dsbcnet.com",ignoreCase = true))
//                        errorLiveData.value = Event("Failed To Connect To server")
//                    else
//                        errorLiveData.value = Event(e.message ?: "")
//                }
            }
        }
    }

    protected fun handleSessionTimeoutResponse(
        e: Throwable, serverResponseErrorCallback: () -> Unit,
        lostInterConnectionErrorCallback: () -> Unit
    ) {
        when (e) {
            is TokenStatusThrowable -> {
                if (e.tokenStatusEnum == TokenStatusEnum.SESSION_TIME_OUT ||
                    e.tokenStatusEnum == TokenStatusEnum.TOKEN_NOT_FOUND
                ) {
                    // _backToLoginScreenLiveData.value = e.message
                } else {
                    serverResponseErrorCallback.invoke()
                }
            }
            is HttpException, is UnknownHostException, is ConnectException -> {
                _lostInternetLiveData.value = Event("Failed To Connect To server")
                lostInterConnectionErrorCallback.invoke()
            }
            else -> {
                _errorLiveData.value = Event("System Error. Please try again later")
            }
        }
    }

    data class TimeOutModel(val message:String, val requestCode:Int)
}