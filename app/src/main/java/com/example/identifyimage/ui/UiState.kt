package com.example.identifyimage.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.identifyimage.R

data class UiState(
    val imageCount: Int = 0,
    val score: Int = 0,
    @DrawableRes val image: Int = R.drawable.sun,
    @StringRes val imageName: Int = R.string.sun,
    val guess: String = ""
)
