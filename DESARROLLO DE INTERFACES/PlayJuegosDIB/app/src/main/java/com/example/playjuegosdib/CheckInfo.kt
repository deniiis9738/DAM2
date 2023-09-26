package com.example.playjuegosdib

import androidx.annotation.DrawableRes

data class CheckInfo (
    @DrawableRes var image: Int,
    var selected: Boolean,
    var title: String,
    var onCheckedChange: (Boolean) -> Unit
)