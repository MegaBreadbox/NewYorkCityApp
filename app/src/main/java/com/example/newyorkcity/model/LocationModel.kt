package com.example.newyorkcity.model

import android.graphics.drawable.AnimatedImageDrawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class LocationModel(
    @DrawableRes val locationImage: Int,
    @StringRes val locationName: Int,
    @StringRes val locationDescription: Int,
    val navigation: String
)