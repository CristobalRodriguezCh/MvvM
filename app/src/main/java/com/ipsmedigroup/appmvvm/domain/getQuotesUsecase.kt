package com.ipsmedigroup.appmvvm.domain

import com.ipsmedigroup.appmvvm.data.Model.QuoteModel
import com.ipsmedigroup.appmvvm.data.QuoteRepository

class getQuotesUsecase {
    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>?{
        return repository.getAllQuote();
    }


}