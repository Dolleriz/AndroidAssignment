package com.example.androidassignment

import com.example.androidassignment.JsonResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path


interface ApiInterface {
    @GET("popular?api_key=301cf14c6b2df9e1eab6b9c10ff98018&language=en-US&page=1")
    fun getData(): Call<JsonResponse>
}