package com.example.myrefrig.data

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myrefrig.data.model.BottomNavItem

object BottomNavItemProvider {
val bottomNavItems : List<BottomNavItem> = listOf(
    BottomNavItem(
        "Продукты",
        "home",
        Icons.Default.Home,
        10
    ),
    BottomNavItem(
        "Рецепты",
        "recipes",
        Icons.Default.Search,
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