package com.example.myrefrig.data.model

data class Album(
    val id: Int,
    val title: String,
    val description: String,
    val imageId: Int,
    val backgroundId: Int,
    val swiped: Boolean = false,
) : java.io.Serializable

