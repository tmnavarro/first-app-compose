package com.example.firstappcompose.ui.model

import androidx.annotation.DrawableRes

data class Hero(
    val name: String,
    val description: String,
    @DrawableRes
    val image: Int
)
