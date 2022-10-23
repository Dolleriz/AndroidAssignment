package com.example.androidassignment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(var movies: List<Movie>, var context: Context) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val image: ImageView

        init{
            title = view.findViewById(R.id.movie_title)
            image = view.findViewById(R.id.movie_img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_card,parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = movies[position].title
        Glide.with(context).load("https://image.tmdb.org/t/p/original" + movies[position].poster_path)
            .into(holder.image)


        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("title", movies[position].title)
            intent.putExtra("overview", movies[position].overview)
            intent.putExtra("image", movies[position].poster_path)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}