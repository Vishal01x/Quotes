package com.exa.android.quotes.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.exa.android.quotes.Model.Quotes
import com.exa.android.quotes.Model.Result
import com.exa.android.quotes.db.Content
import com.exa.android.quotes.repository.QuoteRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel(){

    init {
        val page = 1
        CoroutineScope(Dispatchers.IO).launch {
            quoteRepository.getQuotes(page)
        }
    }

    val quotes : LiveData<List<Content>>
        get() = quoteRepository.quotes

}