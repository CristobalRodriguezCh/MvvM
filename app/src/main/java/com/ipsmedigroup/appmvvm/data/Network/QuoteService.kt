package com.ipsmedigroup.appmvvm.data.Network

import com.ipsmedigroup.appmvvm.core.RetrofitHelper
import com.ipsmedigroup.appmvvm.data.Model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuoteService {
    //todas las llamadas se hacend esde aqui
    private val retrofit = RetrofitHelper.getRetrofit()//instancia

    suspend fun getQuotes():List<QuoteModel>{
        //coorutinas dado que hay que dejar por fuera la ejecucion del hilo principal

        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> = retrofit.create(QuoteApiClient::class.java).getAllQuote()
            response.body() ?: emptyList()
        }
    }
}