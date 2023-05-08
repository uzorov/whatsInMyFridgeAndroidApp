package com.example.myrefrig.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


object Tags {
    final val PRODUCTS = "PRODUCTS"
    final val FAVORITE_RECIPES = "FAVORITE_RECIPES"
    final val USER_FIRST_LAUNCH = "USER_FIRST_LAUNCH"
}

class Database<T>(private val context: Context, private val tag: String,
                  private val objectType: TypeToken<List<T>>
) {


    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(tag, Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveListOfObjects(products: List<T>) {
        val editor = sharedPreferences.edit()
        val productsJson = gson.toJson(products)
        editor.putString(tag, productsJson)
        editor.apply()

      //  Toast.makeText(context, "Успешно сохранено", Toast.LENGTH_SHORT).show()
    }

    fun getListOfObjects(): List<T> {
        val objectsJson = sharedPreferences.getString(tag, null)
        return if (objectsJson != null) {
            //val listType: Type = object : TypeToken<List<T>>() {}.type
            gson.fromJson<List<T>>(objectsJson, objectType.type).toList()
        } else {
            emptyList()
        }
    }

    fun dropAllObjects() {
        val products = listOf<T>()
        val editor = sharedPreferences.edit()
        val productsJson = gson.toJson(products)
        editor.putString(tag, productsJson)
        editor.apply()
    }


}