package com.altabel.coolmovies.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.altabel.coolmovies.entity.FavoriteMovie

@Database(entities = [FavoriteMovie::class], version = 1)
@TypeConverters(DateConverter::class, GenresConverter::class)
abstract class FavoriteMoviesDatabase : RoomDatabase() {

    abstract fun favoriteMovieDataDao(): FavoriteMovieDao
}