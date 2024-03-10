package com.shnayder.android.wewatch.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FilmDao {
    @Insert
    suspend fun insert(film: Film)

    @Update
    suspend fun update(film: Film)

    @Query("SELECT * FROM film")
    suspend fun getAll(): LiveData<List<Film>>

    @Delete
    suspend fun delete(film: Film)
}