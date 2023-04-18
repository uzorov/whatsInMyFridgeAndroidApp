package com.example.myrefrig.data

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myrefrig.data.model.BottomNavItem

object BottomNavItemProvider {
val bottomNavItems : List<BottomNavItem> = listOf(
    BottomNavItem(
        "Продукты",
        "home",
        Icons.Default.ShoppingCart,
        0
    ),
    BottomNavItem(
        "Рецепты",
        "recipes",
        Icons.Default.Search,
        0
    ),
    BottomNavItem(
        "Избранное",
        "favorite",
        Icons.Default.FavoriteBorder,
        0
    ),
    BottomNavItem(
        "Профиль",
        "profile",
        Icons.Default.Person,
        0
    )
)
}