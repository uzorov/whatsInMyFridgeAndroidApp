package com.example.myrefrig.ui.searchable_menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.myrefrig.data.IngredientDataProvider
import com.example.myrefrig.data.model.Ingredient
import com.example.myrefrig.ui.theme.Blue
import java.util.*

@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier
            .fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            if (state.value != TextFieldValue("")) {
                IconButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                }
            }
        },
        singleLine = true,
        shape = RectangleShape, // The TextFiled has rounded corners top left and right by default
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = Blue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun IngredientListItem(ingredient: Ingredient, onItemClick: (Ingredient) -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onItemClick(ingredient) })
            .background(color = Color.Transparent)
            .height(57.dp)
            .fillMaxWidth()
            .padding(PaddingValues(8.dp, 16.dp))

    ) {
        Text(
            text = ingredient.name,
            fontSize = 18.sp,
            color = MaterialTheme.colors.primaryVariant
        )
    }
}

@Composable
fun IngredientList(state: MutableState<TextFieldValue>, onItemClick: (Ingredient) -> Unit) {
    val ingredients = IngredientDataProvider.getIngredients()
    var filteredIngredients: ArrayList<Ingredient>
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        val searchedText = state.value.text
        filteredIngredients = if (searchedText.isEmpty()) {
            ingredients
        } else {
            val resultList = ArrayList<Ingredient>()
            for (ingredient in ingredients) {
                if (ingredient.name.lowercase(Locale.getDefault())
                        .contains(searchedText.lowercase(Locale.getDefault()))
                ) {
                    resultList.add(ingredient)
                }
            }
            resultList
        }
        items(filteredIngredients) { filteredIngredient ->
            IngredientListItem(
                ingredient = filteredIngredient,
                onItemClick = onItemClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryListPreview() {
    val navController = rememberNavController()
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    IngredientList(state = textState, {})
}


@Preview(showBackground = true)
@Composable
fun CountryListItemPreview() {
    //   IngredientListItem(ingredient = "United States 🇺🇸", onItemClick = { })
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    SearchView(textState)
}