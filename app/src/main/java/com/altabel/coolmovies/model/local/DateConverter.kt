package com.altabel.coolmovies.model.local

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun toTimestamp(value: Date): Long = value.time

    @TypeConverter
    fun toDate(value: Long): Date = Date(value)
}