package com.altabel.coolmovies.model.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenresConverter {

    @TypeConverter
    fun toList(value: String): List<Int> {
        val listType = object : TypeToken<ArrayList<Int>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toString(value: List<Int>): String {
        return Gson().toJson(value)
    }
}