package com.altabel.coolmovies.di.module

import android.content.Context
import androidx.room.Room
import com.altabel.coolmovies.app.App
import com.altabel.coolmovies.core.ErrorHandler
import com.altabel.coolmovies.model.local.FavoriteMovieDao
import com.altabel.coolmovies.model.local.FavoriteMoviesDatabase
import com.altabel.coolmovies.model.system.resource.ResourceManager
import com.altabel.coolmovies.model.system.scheduler.AppSchedulers
import com.altabel.coolmovies.model.system.scheduler.SchedulersProvider
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import toothpick.config.Module

class AppModule(
    app: App
) : Module() {

    init {
        bind(Context::class.java).toInstance(app)
        bind(SchedulersProvider::class.java).toInstance(AppSchedulers())
        bind(ResourceManager::class.java).to(ResourceManager::class.java).singletonInScope()
        bind(ErrorHandler::class.java).singletonInScope()

        val database = Room
            .databaseBuilder(app, FavoriteMoviesDatabase::class.java, "favoriteMovies.db")
            .build()
        bind(FavoriteMovieDao::class.java).toInstance(database.favoriteMovieDataDao())

        // Navigation
        val cicerone = Cicerone.create()
        bind(Router::class.java).toInstance(cicerone.router)
        bind(NavigatorHolder::class.java).toInstance(cicerone.navigatorHolder)
    }
}