package com.example.myrefrig.data

import com.example.myrefrig.R
import com.example.myrefrig.data.model.Recipe
import com.example.myrefrig.ui.theme.*

object RecipeDataProvider {
    val masterChiefRecepies: List<Recipe> = mutableListOf(
        Recipe(
            1,
            "Приготовьте королевский завтрак",
            546,
            "Яйца Бенедикта",
            R.drawable.chief,
            Gray,
            TextWhite
        ),
        Recipe(
            1,
            "Паста, как в ресторане",
            566,
            "Карбонара",
            R.drawable.other_chief,
            Green,
            TextWhite
        ),

        Recipe(
            1,
            "Полезный и вкусный завтрак",
            346,
            "Каша овсяная",
            R.drawable.chief,
            Yellow,
            DeepBlue
        ),

        Recipe(
            1,
            "Вкусно и очень дёшево",
            563,
            "Натуральная карамель",
            R.drawable.other_chief,
            Red,
            DeepBlue
        ),

        Recipe(
            1,
            "Самый вкусный бисквит",
            246,
            "Профитроли",
            R.drawable.chief,
            Blue,
            TextWhite
        ),

        Recipe(
            1,
            "Испеките самый популярный пирог",
            587,
            "Шарлотка",
            R.drawable.other_chief,
            Orange,
            DeepBlue
        ),

        )

    val recepies = mutableListOf<Recipe>(
        Recipe(
            id = 1,
            description = "Картофель, посыпанный сахаром",
            calories = 102,
            title = "Сладкий картофель",
           imageURL =  R.drawable.pngegg,
           background_color = Blue,
           textColor =  TextWhite
        ),
        Recipe(
            1,
            "Сгущённое молоко с ванилью",
            50,
            "Крем-брюле",
            R.drawable.pngegg1,
            OrangeYellow2,
            DeepBlue
        ),
        Recipe(
            1,
            "Суп из черепахи в панцире",
            333,
            "Черепаший суп",
            R.drawable.pngegg2,
            BlueViolet3,
            DeepBlue
        ),
        Recipe(
            1,
            "Чипсы со вкусом чеснока к пиву",
            133,
            "Чипсы",
            R.drawable.pngegg3,
            LightOrange,
            DeepBlue
        ),

        )
}