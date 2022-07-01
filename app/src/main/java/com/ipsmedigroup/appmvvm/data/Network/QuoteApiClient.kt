package com.ipsmedigroup.appmvvm.data.Network

import retrofit2.Response
import retrofit2.http.GET
import com.ipsmedigroup.appmvvm.data.Model.QuoteModel

interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuote():Response<List<QuoteModel>>
}