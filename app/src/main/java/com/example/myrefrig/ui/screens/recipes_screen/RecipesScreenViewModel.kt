package com.example.myrefrig.ui.screens.recipes_screen

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrefrig.data.model.Ingredient

class RecipesScreenViewModel : ViewModel() {

    private val _ingredientsInTheFridge = MutableLiveData<MutableList<Ingredient>>()
    val ingredientsInTheFridge : LiveData<MutableList<Ingredient>>
    get() = _ingredientsInTheFridge

    fun addNewIngredient(ingredient: Ingredient){_ingredientsInTheFridge.value!!.add(ingredient)}

    init {
        _ingredientsInTheFridge.value = mutableListOf()
    }
}