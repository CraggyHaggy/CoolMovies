package com.altabel.coolmovies.di

data class PrimitiveWrapper<out T>(val value: T) // see: https://youtrack.jetbrains.com/issue/KT-18918