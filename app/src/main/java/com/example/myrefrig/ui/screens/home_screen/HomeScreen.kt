package com.example.myrefrig.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myrefrig.R
import com.example.myrefrig.data.RecipeDataProvider
import com.example.myrefrig.data.model.Recipe
import com.example.myrefrig.ui.screens.home_screen.HomeScreenViewModel
import com.example.myrefrig.ui.theme.Blue
import com.example.myrefrig.ui.theme.Gray
import com.example.myrefrig.ui.theme.LightRed
import com.example.myrefrig.ui.theme.TextWhite
import com.example.myrefrig.util.NoPaddingAlertDialog
import com.guru.composecookbook.meditation.ui.spacerHeight10
import com.guru.composecookbook.meditation.ui.spacerHeight20
import com.guru.composecookbook.verticalgrid.StaggeredVerticalGrid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.launch

/*
This file contains the Composable functions for the Home Screen UI.
*/


/**
 * Composable function for the Home Screen that displays the UI content. */
@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        HomeScreenContent(viewModel)
    }
}


/**

 * Composable function for the Home Screen UI content. */
@Composable
fun HomeScreenContent(viewModel: HomeScreenViewModel) {
    val recipeOpenState = remember { mutableStateOf(false) }
    val selectedRecipe = remember {
        mutableStateOf(RecipeDataProvider.recepies.take(1)[0])
    }

    Box(modifier = Modifier.fillMaxSize()) {

     //Window that will be displayed only if recipe item was clicked
          OpenRecipeDetailed(recipeOpenState = recipeOpenState, recipe = selectedRecipe.value, viewModel)

        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            item {
                appTitle()
                spacerHeight10()
                discoverNewRecepiesSection()
                spacerHeight20()
                BestRecepiesSection(viewModel.currentBestRecipes, recipeOpenState, selectedRecipe)
                spacerHeight20()
                RecommendationSection(viewModel.currentRecommendedRecipes, recipeOpenState, selectedRecipe)
                spacerHeight20()
                MasterChiefsSection(viewModel.currentChiefRecipes, recipeOpenState, selectedRecipe)
            }
        }
    }
}


/**

 * Composable function for the recommendation section of the Home Screen UI.
 * @param recommendationList The list of recommended recipes. */
@Composable
fun RecommendationSection(
    recommendationList: List<Recipe>,
    recipeOpenState: MutableState<Boolean>,
    selectedRecipe: MutableState<Recipe>
) {
    Column {
        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = stringResource(R.string.recommendation_to_cook),
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        spacerHeight10()
        LazyRow(
            contentPadding = PaddingValues(horizontal = 7.dp),
        ) {
            items(recommendationList.size) {
                RecommendedRecipeItem(
                    recommendationRecipe = recommendationList[it], Modifier
                        .padding(end = 7.5.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(10.dp))
                        .background(LightRed)
                        .wrapContentHeight()
                        .wrapContentWidth()
                        .clickable {
                            selectedRecipe.value = recommendationList[it]
                            recipeOpenState.value = true
                        }
                )
            }
        }
    }
}

/**

 * Composable function for the Best Recipes section of the Home Screen UI.
 * @param bestRecipesList The list of best recipes. */
@Composable
fun BestRecepiesSection(
    bestRecipesList: List<Recipe>,
    recipeOpenState: MutableState<Boolean>,
    selectedRecipe: MutableState<Recipe>
) {

    Text(
        modifier = Modifier.padding(start = 15.dp),
        text = "Лучшие рецепты",
        style = MaterialTheme.typography.h2,

        textAlign = TextAlign.Start,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
    spacerHeight10()

    Row(
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        bestRecipesList.forEachIndexed { index, _ ->
            BestRecipeItem(
                bestRecipe = bestRecipesList[index],
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 7.5.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Blue)
                    .wrapContentHeight()
                    .clickable
                    {
                        selectedRecipe.value = bestRecipesList[index]
                        recipeOpenState.value = true
                    }, TextWhite

            )
        }
    }
}

/**

 * Composable function for the Master Chefs section of the Home Screen UI.
 * @param masterChiefsRecipes The list of master chef recipes. */
@Composable
fun MasterChiefsSection(
    masterChiefsRecipes: List<Recipe>,
    recipeOpenState: MutableState<Boolean>,
    selectedRecipe: MutableState<Recipe>
) {
    val scope = rememberCoroutineScope()
    val state = rememberLazyListState()
    state.disableScrolling(scope)
    Column(
        modifier = Modifier.padding(horizontal = 7.5.dp)
    ) {
        Text(
            text = "Высокая кухня",
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 7.5.dp),
            fontWeight = FontWeight.Bold,
        )
        spacerHeight10()
        val itemSize: Dp = (LocalConfiguration.current.screenWidthDp.dp / 2) - 23.dp
        StaggeredVerticalGrid(maxColumnWidth = 250.dp) {
            masterChiefsRecipes.forEachIndexed { index, _ ->
                MasterChiefItem(
                    masterChiefRecipe = masterChiefsRecipes[index],
                    itemSize,
                    Modifier
                        .padding(horizontal = 7.5.dp, vertical = 7.5.dp)
                        .clickable {
                            selectedRecipe.value = masterChiefsRecipes[index]
                            recipeOpenState.value = true
                        }
                )
            }
        }
    }
}


/**

 * Extension function for [LazyListState] that disables scrolling.
 * @param scope The coroutine scope to launch the scroll operation with. */
fun LazyListState.disableScrolling(scope: CoroutineScope) {
    scope.launch {
        scroll(scrollPriority = MutatePriority.PreventUserInput) {
            awaitCancellation()
        }
    }
}

/**

 * Composable function for the "Discover New Recipes" section of the Home Screen UI. */
@Composable
fun discoverNewRecepiesSection() {
    Column(
        modifier = Modifier.padding(horizontal = 15.dp)
    ) {
        Text(
            text = stringResource(R.string.discoverNew),
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        )
        Text(
            text = stringResource(R.string.discoverRec),
            style = MaterialTheme.typography.body1,
            color = Gray,
            fontSize = 18.sp
        )
    }
}


/**

 * Composable function for the app title section of the Home Screen UI. */
@Composable
fun appTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 15.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    )
    {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Icon",
            modifier = Modifier.size(100.dp)
        )
    }
}


@Composable
fun OpenRecipeDetailed(recipeOpenState: MutableState<Boolean>, recipe: Recipe, homeScreenViewModel : HomeScreenViewModel) {
    if (recipeOpenState.value) {
        NoPaddingAlertDialog(
            onDismissRequest = {
                recipeOpenState.value = false
            },
            confirmButton = {

            },
            dismissButton = {

            },
            backgroundColor = Color.Transparent,
            title = {
            },
            text = {
                   RecipeItem(recipe = recipe, recipeOpenState, homeScreenViewModel)
            }
            ,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecipeItem(recipe: Recipe, recipeOpenState : MutableState<Boolean>, viewModel: HomeScreenViewModel) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()

    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),

            ) {
            GlideImage(
                model = recipe.imageURL
                ,
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
                modifier = Modifier.padding(bottom = 36.dp)
            )

            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                TextButton(
                    modifier = Modifier.padding(start = 6.dp),
                    onClick = { recipeOpenState.value = false },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Blue,
                        backgroundColor = Color.Transparent
                    )
                ) {
                    Text(text = "Назад")

                }

                TextButton(
                    modifier = Modifier.padding(end = 6.dp),
                    onClick = { recipeOpenState.value = false
                       val favor_rec = viewModel.database.getListOfObjects().toMutableList()
                        favor_rec.add(recipe)
                        viewModel.database.saveListOfObjects(
                           favor_rec
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Blue,
                        backgroundColor = Color.Transparent
                    )
                ) {
                    Text(text = "В избранное")
                }
            }
        }
    }
}
