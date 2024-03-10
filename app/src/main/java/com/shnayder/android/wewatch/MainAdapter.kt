package com.shnayder.android.wewatch

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shnayder.android.wewatch.model.Film


class MainAdapter(private val film: Film): RecyclerView.Adapter<MainAdapter.FilmViewHolder>() {
    inner class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        /*val titleTextView: TextView = itemView.findViewById(R.id.title_film)
        val yearTextView: TextView = itemView.findViewById(R.id.year_film)
        val posterImageView: ImageView = itemView.findViewById(R.id.image_film)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        /*val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_all_film, parent, false)
        return FilmViewHolder(itemView)*/
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        /*val currentFilm = film[position]
        holder.titleTextView.text = "${currentFilm.title}"
        holder.yearTextView.text = "${currentFilm.year}"
        holder.posterImageView.setImageResource(currentFilm.poster)*/
    }
    override fun getItemCount(): Int {
        //return film.size
    }
}