package com.ipsmedigroup.appmvvm.data

import com.ipsmedigroup.appmvvm.data.Model.QuoteModel
import com.ipsmedigroup.appmvvm.data.Model.QuoteProvider
import com.ipsmedigroup.appmvvm.data.Network.QuoteService

class QuoteRepository {
    private  val api = QuoteService()

    suspend fun getAllQuote():List<QuoteModel> {
        val response: List<QuoteModel> = api.getQuotes();
        QuoteProvider.quoteModel = response
        return response
    }
}