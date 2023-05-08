package com.example.myrefrig.ui.screens.recipes_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myrefrig.data.model.Ingredient
import com.example.myrefrig.ui.searchable_menu.IngredientList
import com.example.myrefrig.ui.searchable_menu.SearchView
import com.example.myrefrig.ui.theme.Blue
import com.example.myrefrig.ui.theme.TextWhite
import com.example.myrefrig.util.NoPaddingAlertDialog
import kotlin.random.Random


@Composable
fun RecipesScreen(recipesScreenViewModel: RecipesScreenViewModel) {


    val dialogOpen = rememberSaveable { mutableStateOf(false) }
    val textState = remember { mutableStateOf(TextFieldValue("")) }




    LaunchedEffect(recipesScreenViewModel.ingredientsInTheFridge) {
        recipesScreenViewModel.saveInDatabase(recipesScreenViewModel.ingredientsInTheFridge)
    }


        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

            ListOfIngredients(recipesScreenViewModel)
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                BottomButtonToAddTheIngredient(dialogOpen)
                ChooseTheIngredientToPutInTheFridge(
                    dialogOpen = dialogOpen,
                    textState,
                    recipesScreenViewModel
                )
            }
        }
    }


@Composable
fun BottomButtonToAddTheIngredient(dialogOpen: MutableState<Boolean>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.dp), horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                dialogOpen.value = true
            },
            modifier = Modifier
                .width(70.dp)
                .height(40.dp),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Blue, contentColor = TextWhite)
        ) {
            Icon(Icons.Default.Add, contentDescription = "content description")
        }
    }
}

//Диалог, который используется для выбора продукта
@Composable
fun ChooseTheIngredientToPutInTheFridge(
    dialogOpen: MutableState<Boolean>,
    textState: MutableState<TextFieldValue>,
    recipesScreenViewModel: RecipesScreenViewModel,
) {

    if (dialogOpen.value) {
        NoPaddingAlertDialog(onDismissRequest = {
            dialogOpen.value = false
        },
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 15.dp, bottom = 70.dp),
            confirmButton = {
                TextButton(
                    modifier = Modifier.padding(start = 10.dp),
                    onClick = { dialogOpen.value = false },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Blue,
                        backgroundColor = Color.Transparent
                    )
                ) {
                    Text(text = "Отменить")
                }
            },
            dismissButton = {
                TextButton(
                    modifier = Modifier.padding(end = 10.dp),
                    onClick = { dialogOpen.value = false },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Blue,
                        backgroundColor = Color.Transparent
                    )
                ) {
                    Text(text = "Выбрать")

                }
            },
            title = {},
            text = {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    SearchView(textState)
                    IngredientList(
                        state = textState,
                        onItemClick = { ingredient ->
                            recipesScreenViewModel.addNewIngredient(ingredient)
                            dialogOpen.value = false
                        })

                }
            })
    }


}

@Composable
fun ListOfIngredients(
    recipesScreenViewModel: RecipesScreenViewModel,
) {

    val deleteMenuOpenState = remember {
        mutableStateOf(
            Ingredient(
                id = -1,
                name = "Жидкое мыло",
                imageURL = "https://source.unsplash.com/300x300/?Жидкое мыло",
                amount_of_weeks_until_expired = 1
            ),
        )
    }
    LazyColumn(
        modifier = Modifier

            .fillMaxWidth()
            .padding(start = 7.dp, end = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(recipesScreenViewModel.ingredientsInTheFridge) { ingredient ->

            ProductListItem(ingredient = ingredient) {
                deleteMenuOpenState.value = ingredient
            }

            if (deleteMenuOpenState.value != Ingredient(
                    id = -1,
                    name = "Жидкое мыло",
                    imageURL = "https://source.unsplash.com/300x300/?Жидкое мыло",
                    amount_of_weeks_until_expired = 1
                )
            ) {
                ToDeleteItemDialog(
                    ingredient = deleteMenuOpenState.value,
                    { recipesScreenViewModel.delIngredient(deleteMenuOpenState.value) }
                ) {
                    deleteMenuOpenState.value = Ingredient(
                        id = -1,
                        name = "Жидкое мыло",
                        imageURL = "https://source.unsplash.com/300x300/?Жидкое мыло",
                        amount_of_weeks_until_expired = 1
                    )
                }
            }

        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class, ExperimentalFoundationApi::class)
@Composable
fun ProductListItem(ingredient: Ingredient, onLongClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .combinedClickable(onLongClick = onLongClick) {}
    ) {


        GlideImage(
            model = ingredient.imageURL,
            contentDescription = ingredient.name,
            modifier = Modifier.size(80.dp),
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = ingredient.name, style = MaterialTheme.typography.h6)

            Text(text = (ingredient.amount_of_weeks_until_expired * Random.nextInt(1,10)).toString() + "КК", style = MaterialTheme.typography.body1)

            Row {
                Icon(
                    imageVector = Icons.Filled.Warning,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(24.dp)
                )

                Text(text = "Срок годности истекает через " + ingredient.amount_of_weeks_until_expired.toString() + " недель")
            }
        }
    }
}

@Composable
fun ToDeleteItemDialog(ingredient: Ingredient, onLongClick: () -> Unit, onDismissRequest: () -> Unit) {

        Surface() {

            AlertDialog(onDismissRequest = onDismissRequest,
                buttons = {

                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    TextButton(onClick = onDismissRequest) {
                        Text(text = "Отмена", color = MaterialTheme.colors.secondaryVariant)
                    }

                    TextButton(onClick = {
                        onLongClick()
                        onDismissRequest()
                    }) {
                        Text(text = "Удалить", color = MaterialTheme.colors.secondaryVariant)
                    }}
                },
                title = { Text(text = "Удалить продукт") },
                text = { Text(text = "Вы действительно хотите удалить " + ingredient.name.lowercase() + "?") }
            )
        }
}

@Preview(showBackground = true)
@Composable
fun RecipesPreview() {
    // RecipesScreen(RecipesScreenViewModel(con))
}



