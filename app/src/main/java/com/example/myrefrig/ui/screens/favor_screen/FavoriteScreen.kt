package com.example.myrefrig.ui.screens.favor_screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myrefrig.data.model.Recipe
import com.example.myrefrig.ui.screens.home_screen.HomeScreenViewModel

@Composable
fun FavoriteScreen(homeScreenViewModel: HomeScreenViewModel) {

    FavoriteRecipesScreen(favoriteRecipes = homeScreenViewModel.database.getListOfObjects())
}

@Composable
fun FavoriteRecipesScreen(favoriteRecipes: List<Recipe>) {
    val visible by remember { mutableStateOf(true) }

    AnimatedVisibility(visible = visible) {
        Column {

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(favoriteRecipes) { recipe ->
                    RecipeItem(recipe = recipe)
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecipeItem(recipe: Recipe) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = { /* TODO: navigate to recipe details */ })
                .padding(16.dp)
        ) {
            GlideImage(
                model = recipe.imageURL,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(16.dp))
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = recipe.title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = recipe.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
    }
}

