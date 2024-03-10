package com.shnayder.android.wewatch

import androidx.lifecycle.LiveData
import com.shnayder.android.wewatch.model.Film
import com.shnayder.android.wewatch.model.FilmDao

////репозиторий, который будет обращаться к dao-интерфейсу и манипулировать данными базы данных
class FilmRepository(private val filmDao: FilmDao) {

    suspend fun getAll(){
        val allFilms: LiveData<List<Film>> = filmDao.getAll()
    }

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
