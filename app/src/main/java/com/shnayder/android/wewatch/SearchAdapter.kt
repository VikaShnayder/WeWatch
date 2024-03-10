package com.shnayder.android.wewatch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shnayder.android.wewatch.filmDB.Film
import com.bumptech.glide.Glide

//context использую для картинки
class SearchAdapter(var list: List<Film>,var context:Context): RecyclerView.Adapter<SearchAdapter.FilmViewHolder>() {
    // Ссылки на виджеты в макете элемента списка
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
        holder.titleTextView.text = list[position].Title
        holder.yearTextView.text = list[position].Year.toString()

        Glide.with(context)
            .load(list[position].Poster) // Путь к файлу изображения
            .into(holder.posterImageView)
    }
    override fun getItemCount(): Int {
        return list.size
    }
}