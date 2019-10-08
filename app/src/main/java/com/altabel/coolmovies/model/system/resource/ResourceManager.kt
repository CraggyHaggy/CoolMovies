package com.altabel.coolmovies.model.system.resource

import android.content.Context
import javax.inject.Inject

class ResourceManager @Inject constructor(
    private val context: Context
) {

    fun getString(id: Int): String = context.getString(id)

    fun getString(id: Int, vararg formatArgs: Any): String {
        return context.resources.getString(id, formatArgs)
    }
}
