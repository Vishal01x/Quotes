package com.exa.android.quotes.api

import com.exa.android.quotes.Model.Quotes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {
    @GET("quotes")
    suspend fun getQuotes(@Query("page")page : Int) : Response<Quotes>
}