package com.shnayder.android.wewatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.shnayder.android.wewatch.retrofit.Film
import com.shnayder.android.wewatch.retrofit.FilmApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val searchFilm = findViewById<Button>(R.id.search_film)
        val miniSearchFilm = findViewById<ImageView>(R.id.mini_search_film)
        val enterTitleFilm = findViewById<EditText>(R.id.enter_title_film)
        val enterYearFilm = findViewById<EditText>(R.id.enter_year_film)

        searchFilm.setOnClickListener{
            val title = enterTitleFilm.text.toString()
            val year = enterYearFilm.text.toString()

            if(title != "" && year!=""){
                val intent = Intent(this@SearchActivity, AllFilmActivity::class.java)
                intent.putExtra("title", title)
                intent.putExtra("year", year)
                startActivity(intent)
            } else if(title != ""){
                val intent = Intent(this@SearchActivity, AllFilmActivity::class.java)
                intent.putExtra("title", title)
                startActivity(intent)
            } else
                Toast.makeText(this@SearchActivity, "Для поиска введите название фильма.", Toast.LENGTH_SHORT).show()
        }












        miniSearchFilm.setOnClickListener{
            val title = enterTitleFilm.text.toString()
            if(title != ""){
                val intent = Intent(this@SearchActivity, AllFilmActivity::class.java)
                intent.putExtra(title, title)
                startActivity(intent)
            } else
                Toast.makeText(this@SearchActivity, "Для поиска введите название фильма.", Toast.LENGTH_SHORT).show()
        }

    }
}