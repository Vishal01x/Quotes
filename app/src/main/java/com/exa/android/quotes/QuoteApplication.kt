package com.exa.android.quotes

import android.app.Application
import com.exa.android.quotes.api.QuoteService
import com.exa.android.quotes.api.RetrofitHelper
import com.exa.android.quotes.db.QuoteDatabase
import com.exa.android.quotes.repository.QuoteRepository

class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val quoteService = RetrofitHelper.getInstance().create(QuoteService::class.java)
        val quoteDb = QuoteDatabase.getdb(applicationContext)
        quoteRepository = QuoteRepository(quoteService, quoteDb,applicationContext)
    }
}
