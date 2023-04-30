package com.example.myrefrig.data.model

import androidx.compose.ui.graphics.Color
import com.example.myrefrig.ui.theme.TextWhite

data class Recipe(
    val id: Int,
    val description: String,
    val calories: Int,
    val ingredients: List<Ingredient>,
    val title: String,
    val imageURL: String,
    val background_color: Color = Color.Gray,
    val textColor: Color = TextWhite,
)
