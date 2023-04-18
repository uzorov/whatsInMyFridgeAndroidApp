package com.example.myrefrig

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myrefrig.ui.components.HomeScreen
import com.example.myrefrig.ui.screens.RecipesScreen
import kotlinx.coroutines.delay


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "recipes") {

        composable("home") {

            RecipesScreen()
        }
        composable("recipes") {
            HomeScreen()
        }
        composable("favorite") {
            FavoriteScreen()
        }
        composable("profile") {
            ProfileScreen()
        }

    }
}

@Composable
fun InitialNavigation(navController: NavHostController, viewModel: MainActivityViewModel) {
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController)
        }

        composable("greeting") {
            Greeting(viewModel = viewModel, navController)
        }

        composable("scaffold") {
            ScaffoldScreen(viewModel = viewModel)
        }
    }

}

@Composable
fun ScaffoldScreen(viewModel: MainActivityViewModel) {
    val navHostController = rememberNavController()

    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    items = viewModel.bottomItems,
                    navController = navHostController,
                    OnItemClick = {
                        navHostController.navigate(it.route)
                    })
            },
            content = {
                Box(modifier = Modifier.padding(it)) {
                    Navigation(navController = navHostController)
                }
            }
        )
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            1f,
            animationSpec = tween(500),
            block = {
                OvershootInterpolator(1.2f).getInterpolation(this.value)
            }
        )
        delay(1000L)

        //TODO: Find out if the user had launch the app before and make decision should we or should not show the greeting

        val userSawGreetingBefore = false

        if (!userSawGreetingBefore)
            navController.navigate("greeting")
        else {
            navController.navigate("scaffold")
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.scale(scale.value)
        )


    }
}




@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Экран с описанием профиля")
    }
}

@Composable
fun FavoriteScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Экран с избранными рецептами")
    }
}