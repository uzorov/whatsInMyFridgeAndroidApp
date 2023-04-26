package com.example.myrefrig.ui.screens.home_screen

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrefrig.data.RecipeDataProvider
import com.example.myrefrig.data.model.Recipe

class HomeScreenViewModel : ViewModel() {

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