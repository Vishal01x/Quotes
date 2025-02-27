package com.exa.android.quotes.repository

sealed class Response<T>(val data : T? = null, val error : String ? = null) {
    class Loading<T>(): Response<T>()
    class Success<T>(data: T? = null) : Response<T>(data = data)
    class Failed<T>(error: String?=null): Response<T>(error = error)
}