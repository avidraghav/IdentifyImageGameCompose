package com.example.identifyimage.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ImageData(
    @DrawableRes val imageResourceId: Int,
    @StringRes val imageIdentification: Int
)