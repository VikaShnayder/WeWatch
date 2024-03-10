package com.shnayder.android.wewatch

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.shnayder.android.wewatch.filmDB.Film
import com.shnayder.android.wewatch.filmDB.FilmDao

////репозиторий, который будет обращаться к dao-интерфейсу и манипулировать данными базы данных
class FilmRepository(private val filmDao: FilmDao) {

    val allFilms: LiveData<List<Film>> = filmDao.getAll()

    suspend fun insert(film: Film){
        filmDao.insert(film)
    }

    suspend fun delete(film: Film){
        filmDao.delete(film)
    }

    suspend fun update(film: Film){
        filmDao.update(film)
    }
}
