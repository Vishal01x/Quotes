package com.exa.android.quotes.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.exa.android.quotes.Model.Result

@Dao
interface QuoteDao {

   @Query("select content from quotes")
    fun getQuotes() : List<Content>

    @Insert
    suspend fun insertQuote(results: List<Result>)

}

data class Content(val content: String)