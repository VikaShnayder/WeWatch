package com.shnayder.android.wewatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.shnayder.android.wewatch.retrofit.FilmApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleFilm = findViewById<TextView>(R.id.title_film)
        val yearFilm = findViewById<TextView>(R.id.year_film)
        val imageFilm = findViewById<ImageView>(R.id.image_film)
        val addFilmButton = findViewById<Button>(R.id.add_film)
        val openSearchFilm = findViewById<FloatingActionButton>(R.id.open_search_film)

        openSearchFilm.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
        //базовая инстанция
        val retrrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        //создаем класс
        val filmApi = retrrofit.create(FilmApi::class.java)

        //IO-input и output
        CoroutineScope(Dispatchers.IO).launch {
            //выдает ответ по api запросу.не надо делать на основном потоке
            val film = filmApi.getFilmById()
            //уже делать на основном потоке обновление данных
            runOnUiThread{

            }
        }

    }
}