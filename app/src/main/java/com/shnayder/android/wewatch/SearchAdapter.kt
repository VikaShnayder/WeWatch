package com.shnayder.android.wewatch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shnayder.android.wewatch.filmDB.Film

class SearchAdapter(var list: List<Film>): RecyclerView.Adapter<SearchAdapter.FilmViewHolder>() {
    inner class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.title_film)
        val yearTextView: TextView = itemView.findViewById(R.id.year_film)
        val posterImageView: ImageView = itemView.findViewById(R.id.image_film)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_search, parent, false)
        return FilmViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val currentFilm = list[position]
        holder.titleTextView.text = "${currentFilm.title}"
        holder.yearTextView.text = "${currentFilm.year}"
        holder.posterImageView.setImageResource(currentFilm.poster)
    }
    override fun getItemCount(): Int {
        return list.size
    }
}