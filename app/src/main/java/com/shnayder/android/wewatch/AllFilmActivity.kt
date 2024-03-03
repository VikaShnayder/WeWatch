package com.shnayder.android.wewatch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shnayder.android.wewatch.retrofit.Film
import com.shnayder.android.wewatch.retrofit.FilmApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AllFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_film)


        //перехватваем запросы body. okhttp
        val interseptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interseptor)
            .build()

        //базовая инстанция
        val retrrofit = Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        CoroutineScope(Dispatchers.Main).launch {
            val title : String? = intent.getStringExtra("title")
            val year : String? = intent.getStringExtra("year")

            val filmApi = retrrofit.create(FilmApi::class.java)
            if (title != null && year != null){
                val film = filmApi.getFilmByTitleAndYear("e451f001", title,year)

            }else if (title != null) {
                val film = filmApi.getFilmByTitle("e451f001", title)
            }
        }

        //при нажатии (выборе) фильма->
        /*
            val intent = Intent(this@AllFilmActivity, AddActivity::class.java)
            startActivity(intent)
        */
    }
}