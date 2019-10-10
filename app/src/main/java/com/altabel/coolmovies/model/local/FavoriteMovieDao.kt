package com.altabel.coolmovies.model.local

import androidx.room.*
import com.altabel.coolmovies.entity.FavoriteMovie
import io.reactivex.Observable

@Dao
interface FavoriteMovieDao {

    @Query("select * from movies")
    fun getAll(): Observable<List<FavoriteMovie>>

    @Query("select COUNT() from movies where id == :id")
    fun isMovieFavorite(id: Int): Observable<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: FavoriteMovie)

    @Delete
    fun delete(movie: FavoriteMovie)
}