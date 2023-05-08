package com.example.myrefrig.ui.screens.recipes_screen

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.AndroidViewModel
import com.example.myrefrig.data.Database
import com.example.myrefrig.data.Tags
import com.example.myrefrig.data.model.Ingredient
import com.google.gson.reflect.TypeToken


class RecipesScreenViewModel(application: Application) : AndroidViewModel(application) {

    private val database = Database(application, Tags.PRODUCTS, object : TypeToken<List<Ingredient>>() {})


    private var _ingredientsInTheFridge = mutableStateListOf<Ingredient>()
    val ingredientsInTheFridge: List<Ingredient>
        get() = _ingredientsInTheFridge

    fun addNewIngredient(ingredient: Ingredient) {
        _ingredientsInTheFridge.add(ingredient)
    }

    fun delIngredient(ingredient: Ingredient) {
        _ingredientsInTheFridge.remove(ingredient)
    }

    fun saveInDatabase(ingredients: List<Ingredient>) {
        database.saveListOfObjects(ingredients)
    }

    init {
        _ingredientsInTheFridge = database.getListOfObjects().toMutableStateList()
    }

//Temporary to clear database
    override fun onCleared() {
        database.dropAllObjects()
    }
}