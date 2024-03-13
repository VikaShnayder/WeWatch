package com.shnayder.android.wewatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

    private var titleIntentResponce: String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        titleIntentResponce =  intent.getStringExtra("title") ?: ""

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
            var filmResponce  = filmApi.getFilmByTitle("e451f001", titleIntentResponce)

            runOnUiThread {
                //ответ сервера
                list = filmResponce.items?: emptyList()
                Log.d("list",list.toString())
                //рисует данные
                adapter = SearchAdapter(list, this@SearchActivity)
                //помещает
                recyclerView.adapter = adapter
            }
        }



    }


}
