package com.example.myrefrig.data.model

import androidx.compose.ui.graphics.Color
import com.example.myrefrig.ui.theme.TextWhite

data class Recipe(
    val id: Int,
    val description: String,
    val calories: Int,
    val title: String,
    val imageURL: Int,
    val background_color: Color = Color.Gray,
    val textColor: Color = TextWhite,
)
