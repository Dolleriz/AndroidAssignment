package com.example.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainMovieActivity : AppCompatActivity() {
    private var layoutManager : RecyclerView.LayoutManager? = null
    private var viewHolderAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>? = null
    private lateinit var movieList: ArrayList<Movie>
    lateinit var intentValue: String
    lateinit var retrofitClient: RetrofitClient
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_list)
        intentValue = intent.getStringExtra("Type").toString()
        retrofitClient = RetrofitClient(intentValue)
        recyclerView = findViewById(R.id.recycler)
        fetchPosts();
    }

    private fun fetchPosts() {
        val retrofitData: Call<JsonResponse> = retrofitClient.getRetroFitClient().getData()

        retrofitData.enqueue(object : Callback<JsonResponse?> {
            override fun onResponse(call: Call<JsonResponse?>, response: Response<JsonResponse?>) {
                val jsonResponse: JsonResponse = response.body()!!
                movieList = jsonResponse.results
                val moviesAdapter: MovieAdapter = MovieAdapter(movieList, baseContext)
                recyclerView.layoutManager = LinearLayoutManager(baseContext)
                recyclerView.adapter = moviesAdapter            }

            override fun onFailure(call: Call<JsonResponse?>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }
        })


    }
}