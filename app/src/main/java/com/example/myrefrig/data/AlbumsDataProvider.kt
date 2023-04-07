package com.example.myrefrig.data

import com.example.myrefrig.R
import com.example.myrefrig.data.model.Album

object AlbumsDataProvider {
    val albums = mutableListOf<Album>(
        Album(
            id =1,
            title = "Отслеживание срока годности продуктов",
            description = "Смотрите через сколько закончится срок годности продуктов, не открывая холодильник",
            imageId = R.drawable.supplies_ic,
            backgroundId = R.color.green_greeting_screen
        ),
        Album(
            id =1,
            title = "Просмотр рецептов блюд",
            description = "Просматривайте подборки блюд, которые можно приготовить из ваших продуктов",
            imageId = R.drawable.book_ic,
            backgroundId = R.color.yellow_greeting_screen
        ),
        Album(
            id =1,
            title = "Современный дизайн",
            description = "Оцените удобство и простоту использования приложения",
            imageId = R.drawable.refrig_ic,
            backgroundId = R.color.blue_greeting_screen
        ),
    )
}