package com.ipsmedigroup.appmvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipsmedigroup.appmvvm.data.Model.QuoteModel
import com.ipsmedigroup.appmvvm.data.Model.QuoteProvider
import com.ipsmedigroup.appmvvm.domain.getQuotesUsecase
import kotlinx.coroutines.launch
import java.lang.Math.random

class QuoteViewModel:ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()//se encarga de estar pendiente

    val getQuotesUseCase = getQuotesUsecase()
    var listQuote:List<QuoteModel> = emptyList()

    fun onCreate(){
        viewModelScope.launch {//HILOS DE EJECUCION
            val result:List<QuoteModel>? = getQuotesUseCase()
            if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                listQuote = result;
            }
        }
    }

    fun quoteGet(){
        viewModelScope.launch {
           //val result:List<QuoteModel>? = getQuotesUseCase()
            val num = (0..10).random()
            /*if (!result.isNullOrEmpty()){
                quoteModel.postValue(result[num])
            }*/
            quoteModel.postValue(listQuote[num])
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