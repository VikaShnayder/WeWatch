package com.shnayder.android.wewatch.retrofit

import retrofit2.http.GET

/*интерфейс продукт api
(прописываем запросы, которые будет отправлять retrofit/
GET-получить)*/
interface FilmApi {
    @GET("?i=tt3896198&apikey=e451f001")
    fun getFilmById():Film
}
