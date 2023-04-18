package com.example.myrefrig.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.MutatePriority
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrefrig.data.RecipeDataProvider
import com.example.myrefrig.data.model.Recipe
import com.example.myrefrig.R
import com.example.myrefrig.ui.theme.*
import com.guru.composecookbook.meditation.ui.spacerHeight10
import com.guru.composecookbook.meditation.ui.spacerHeight20
import com.guru.composecookbook.verticalgrid.StaggeredVerticalGrid
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.launch

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            item {
                appTitle()
                spacerHeight10()
                discoverNewRecepiesSection()
                spacerHeight20()
                BestRecepiesSection()
                spacerHeight20()
                RecommendationSection(
                    RecipeDataProvider.recepies
                )
                spacerHeight20()
                MasterChiefsSection(
                    RecipeDataProvider.masterChiefRecepies
                )
            }
        }
    }
}

@Composable
fun RecommendationSection(recommendationList: MutableList<Recipe>) {
    Column {
        Text(
            modifier = Modifier.padding(start = 15.dp),
            text = "Рекомендуем приготовить",
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
                RecipeItem(recommendationRecipe = recommendationList[it])
            }
        }
    }
}


@Composable
fun BestRecepiesSection() {

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
        BestRecipeItem(
            Recipe(
                1,
                "Очень хороший рецепт",
                457,
                "Вяленая шумшура",
                R.drawable.supplies_ic,
                BlueViolet1,
                TextWhite
            ),
            Modifier
                .weight(1f)
                .padding(end = 7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(Blue)
                .wrapContentHeight(), TextWhite
        )
        BestRecipeItem(
            bestRecipe = Recipe(
                1,
                "Толстожопая соседка готовила отличные наваристые щи",
                1312,
                "Щи из капусты",
                R.drawable.soup,
                Yellow,
                TextWhite
            ),
            modifier = Modifier
                .weight(1f)
                .padding(start = 7.5.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(Orange)
                .wrapContentHeight(),
            textColor = DeepBlue
        )

    }
}

@Composable
fun MasterChiefsSection(masterChiefsRecipes: List<Recipe>) {
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
                MasterChiefItem(masterChiefRecipe = masterChiefsRecipes[index], itemSize)
            }
        }
    }
}


fun LazyListState.disableScrolling(scope: CoroutineScope) {
    scope.launch {
        scroll(scrollPriority = MutatePriority.PreventUserInput) {
            awaitCancellation()
        }
    }
}

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
