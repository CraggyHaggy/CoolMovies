package com.altabel.coolmovies.extension

import android.content.Context
import android.graphics.Color
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.util.DisplayMetrics
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace
import java.text.SimpleDateFormat
import java.util.*

fun Navigator.setLaunchScreen(screen: SupportAppScreen) {

    applyCommands(
        arrayOf(
            BackTo(null),
            Replace(screen)
        )
    )
}

fun Fragment.showSnackMessage(message: String) {
    view?.let {
        val ssb = SpannableStringBuilder().apply {
            append(message)
            setSpan(
                ForegroundColorSpan(Color.WHITE),
                0,
                message.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        Snackbar.make(it, ssb, Snackbar.LENGTH_LONG).show()
    }
}

fun View.visible(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}

fun Context.dpToPx(dp: Float) =
    Math.round(dp * (resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT))

fun Date.formatUi() = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(time)