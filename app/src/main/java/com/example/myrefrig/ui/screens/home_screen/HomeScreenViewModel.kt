package com.example.myrefrig.ui.screens.home_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.myrefrig.data.Database
import com.example.myrefrig.data.RecipeDataProvider
import com.example.myrefrig.data.Tags
import com.example.myrefrig.data.model.Recipe
import com.google.gson.reflect.TypeToken

class HomeScreenViewModel(application: Application) : AndroidViewModel(application) {

    val database = Database(application, Tags.FAVORITE_RECIPES, object : TypeToken<List<Recipe>>() {})

    private val _currentBestRecipes: MutableList<Recipe> = mutableListOf()
    val currentBestRecipes: List<Recipe>
        get() = _currentBestRecipes

    private val _currentRecommendedRecipes: MutableList<Recipe> = mutableListOf()
    val currentRecommendedRecipes: List<Recipe>
        get() = _currentRecommendedRecipes

    private val _currentChiefRecipes: MutableList<Recipe> = mutableListOf()
    val currentChiefRecipes: List<Recipe>
        get() = _currentChiefRecipes

init {
    val currentRecipes : MutableList<Recipe> = RecipeDataProvider.recepies.take(12) as MutableList<Recipe>

    _currentBestRecipes.addAll(currentRecipes.take(2))
    currentRecipes.removeAll(currentRecipes.take(2))

    _currentRecommendedRecipes.addAll(currentRecipes.take(4))
    currentRecipes.removeAll(currentRecipes.take(4))

    _currentChiefRecipes.addAll(currentRecipes.take(6))
    currentRecipes.removeAll(currentRecipes.take(6))
}
}