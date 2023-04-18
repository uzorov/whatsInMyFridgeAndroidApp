package com.example.myrefrig.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myrefrig.R
import com.example.myrefrig.data.model.Ingridient
import com.example.myrefrig.data.model.Recipe
import com.example.myrefrig.ui.SearchableExpandedDropDownMenu
import com.example.myrefrig.ui.theme.LittleBlack

@Composable
fun RecipesScreen() {
    Box(

        modifier = Modifier
            .fillMaxSize()
            .padding(9.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column() {


            SearchableExpandedDropDownMenu(
                listOfItems = listOf(
                    Ingridient(
                        1,
                        "12-10-12",
                        "Картофель",
                        R.drawable.cat
                    ),
                    Ingridient(
                        1,
                        "12-10-12",
                        "Колбаса",
                        R.drawable.pngegg1
                    ),
                    Ingridient(
                        1,
                        "12-10-12",
                        "Огурцы",
                        R.drawable.pngegg1
                    ),
                    Ingridient(
                        1,
                        "12-10-12",
                        "Селёдка",
                        R.drawable.pngegg2
                    ),
                    Ingridient(
                        1,
                        "12-10-12",
                        "Помидоры",
                        R.drawable.pngegg3
                    ),
                ),
                dropdownItem = {
                    Row() {
                        Image(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = it.image),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.padding(7.dp))
                        Text(text = it.name, color = LittleBlack)
                    }
                },
                defaultItem = {
                },
                onDropDownItemSelected = {

                },

                )
        }
    }
}
