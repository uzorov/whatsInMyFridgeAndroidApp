package com.example.myrefrig.data.model

import androidx.compose.ui.graphics.Color

data class Album(
    val id: Int,
    val title: String,
    val description: String,
    val imageId: Int,
    val backgroundColor: Color,
    val swiped: Boolean = false,
) : java.io.Serializable

