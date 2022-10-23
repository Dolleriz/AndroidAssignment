package com.example.androidassignment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient(parameter: String?) {


    private val url: String =  "https://api.themoviedb.org/3/movie/"


    fun getRetroFitClient(): ApiInterface {
        return Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }
}