package com.example.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details_activity)
        val image = findViewById<ImageView>(R.id.movie_img);
        val textTitle = findViewById<TextView>(R.id.movie_title);
        val textOverview = findViewById<TextView>(R.id.movie_details);
        val intentTitle = intent.getStringExtra("title");
        val intentOverview = intent.getStringExtra("overview");
        val intentImage = intent.getStringExtra("image")


        Glide.with(baseContext).load("https://image.tmdb.org/t/p/original" + intentImage.toString())
        .into(image)
        textTitle.text = intentTitle
        textOverview.text = intentOverview
    }
}