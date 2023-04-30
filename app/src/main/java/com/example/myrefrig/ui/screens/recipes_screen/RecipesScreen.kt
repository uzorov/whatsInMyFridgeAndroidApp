package com.example.myrefrig.ui.screens.recipes_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myrefrig.data.model.Ingredient
import com.example.myrefrig.ui.searchable_menu.IngredientList
import com.example.myrefrig.ui.searchable_menu.IngredientListItem
import com.example.myrefrig.ui.searchable_menu.SearchView
import com.example.myrefrig.ui.theme.Blue
import com.example.myrefrig.ui.theme.TextWhite
import com.example.myrefrig.util.NoPaddingAlertDialog



@Composable
fun RecipesScreen(navController: NavController) {


    val dialogOpen = remember { mutableStateOf(false) }
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val viewModel: RecipesScreenViewModel = viewModel()
    val fridgeState = remember {
    mutableStateListOf<Ingredient>()}


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

        ListOfIngredients(fridgeState)
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            BottomButtonToAddTheIngredient(dialogOpen)
            ChooseTheIngredientToPutInTheFridge(dialogOpen = dialogOpen, textState, fridgeState)
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
    fridgeState: SnapshotStateList<Ingredient>
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
                            fridgeState.add(ingredient)
                            dialogOpen.value = false
                        })

                }
            })
    }


}

@Composable
fun ListOfIngredients(fridgeState: SnapshotStateList<Ingredient>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 7.dp, end = 7.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(fridgeState) { ingredient ->
            IngredientItem(
                ingredient = ingredient
            )
        }
    }
}

@Composable
fun IngredientItem(ingredient: Ingredient) {
    Row(
        modifier = Modifier
            .clickable(onClick = { })
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

@Preview(showBackground = true)
@Composable
fun RecipesPreview() {
    val navController = rememberNavController()
    RecipesScreen(navController = navController)
}



