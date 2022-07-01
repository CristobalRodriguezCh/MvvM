package com.ipsmedigroup.appmvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipsmedigroup.appmvvm.data.Model.QuoteModel
import com.ipsmedigroup.appmvvm.data.Model.QuoteProvider
import com.ipsmedigroup.appmvvm.domain.getQuotesUsecase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Math.random

class QuoteViewModel:ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()//se encarga de estar pendiente
    val isLoading = MutableLiveData<Boolean>()
    val getQuotesUseCase = getQuotesUsecase()
    var listQuote:List<QuoteModel> = emptyList()

    fun onCreate(){
        viewModelScope.launch {//HILOS DE EJECUCION
            isLoading.postValue(true)//se hace visible
            val result:List<QuoteModel>? = getQuotesUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                listQuote = result;
                isLoading.postValue(false)
            }
        }
    }

    fun quoteGet(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val num = (0..10).random()
            /*if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[num])
            }*/
            delay(1300L)
            quoteModel.postValue(listQuote[num])
            isLoading.postValue(false)
        }
    }



    /*
    fun randomQuote(){
        //val currentQoute: QuoteModel = QuoteProvider.random()
        //se trae un dato random
        //quoteModel.postValue(currentQoute)
        //se hace una llamada de cambios
    }*/


}