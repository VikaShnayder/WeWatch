package com.shnayder.android.wewatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.shnayder.android.wewatch.model.Film
import com.shnayder.android.wewatch.model.SearchResponse
import com.shnayder.android.wewatch.retrofit.FilmApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivity : AppCompatActivity() {
    private lateinit var list: List<Film>
    private lateinit var adapter: SearchAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

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
            val filmApi = retrrofit.create(FilmApi::class.java)

            val title : String? = intent.getStringExtra("title")
            val year : String? = intent.getStringExtra("year")

            if (title != null && year != null){
                var filmResponce  = filmApi.getFilmByTitleAndYear("e451f001", title,year)

                runOnUiThread {
                    list = filmResponce.items?: emptyList()
                    adapter = SearchAdapter(list, this@SearchActivity)
                    recyclerView.adapter = adapter
                }

            }else if (title != null) {
                //filmResponce = filmApi.getFilmByTitle("e451f001", title)
                //....
            }
        }

    }
}
