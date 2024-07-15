package com.exa.android.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.exa.android.quotes.api.QuoteService
import com.exa.android.quotes.api.RetrofitHelper
import com.exa.android.quotes.repository.QuoteRepository
import com.exa.android.quotes.viewmodel.QuoteViewModel
import com.exa.android.quotes.viewmodel.QuotesFactory

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: QuoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = (application as QuoteApplication).quoteRepository

        viewModel = ViewModelProvider(this,QuotesFactory(repository))[QuoteViewModel::class.java]

        val txt = findViewById<TextView>(R.id.text)

        viewModel.quotes.observe(this) {
            txt.text = it.toString()
        }
    }
}