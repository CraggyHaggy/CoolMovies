package com.altabel.coolmovies.model.local

import androidx.room.*
import com.altabel.coolmovies.entity.FavoriteMovie
import io.reactivex.Observable

@Dao
interface FavoriteMovieDao {

    @Query("SELECT * from movies")
    fun getAll(): Observable<List<FavoriteMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: FavoriteMovie)

    @Delete
    fun delete(movie: FavoriteMovie)
}