package com.shnayder.android.wewatch.retrofit

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/*интерфейс продукт api
(прописываем запросы, которые будет отправлять retrofit/
GET-получить)*/

interface FilmApi {
    @GET("/")
    suspend fun getFilmByTitle(@Query("apikey") apikey: String, @Query("s") title: String):Film
    @GET("/")
    suspend fun getFilmByTitleAndYear(@Query("apikey") apikey: String, @Query("s") title: String, @Query("y") year: String):Film
}
