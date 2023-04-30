package com.example.myrefrig.data.model

data class Ingredient(
    val id : Int,
    val name : String,
    val imageURL : String,
    val amount_of_weeks_until_expired : Int
)
