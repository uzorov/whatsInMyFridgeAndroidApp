package com.example.myrefrig.data.model

import java.util.Date

data class Recepy(
    val id : Int,
    val name : String,
    val calories : Int,
    val expire_date : Date
)
