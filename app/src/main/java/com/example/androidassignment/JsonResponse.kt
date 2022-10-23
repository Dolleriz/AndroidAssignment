package com.example.androidassignment

import com.google.gson.annotations.SerializedName

class JsonResponse(
    @SerializedName("results")
    var results: ArrayList<Movie>)
