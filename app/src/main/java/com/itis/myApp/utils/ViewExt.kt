package com.itis.myApp.utils

import android.view.View
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    text: String,
    @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG
) = Snackbar.make(this, text, duration).show()