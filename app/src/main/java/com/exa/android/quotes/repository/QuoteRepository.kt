package com.exa.android.quotes.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exa.android.quotes.Model.Quotes
import com.exa.android.quotes.Model.Result
import com.exa.android.quotes.Util.NetworkUtil
import com.exa.android.quotes.api.QuoteService
import com.exa.android.quotes.db.Content
import com.exa.android.quotes.db.QuoteDatabase
class QuoteRepository(
    private val quoteService: QuoteService,
    private val quoteDatabase: QuoteDatabase,
    private val context: Context
) {

    private val _quotes = MutableLiveData<List<Content>>()

    val quotes: LiveData<List<Content>>
        get() = _quotes

    suspend fun getQuotes(page: Int) {
        if (NetworkUtil.isNetworkAvailable(context)) {
            val result = quoteService.getQuotes(page)
            if (result.body() != null) {
                quoteDatabase.quotesDao().insertQuote(result.body()!!.results)
                val data = quoteDatabase.quotesDao().getQuotes()
                _quotes.postValue(data)
            }
        }
    }
}

/* here use the reponse sealed class, where if successfully retrieve data then put in
* success portion else in failure class and use the same in view model and make the live data
* of Response<Quote>.
 */