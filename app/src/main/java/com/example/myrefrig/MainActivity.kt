package com.example.myrefrig


import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.myrefrig.ui.screens.home_screen.HomeScreenViewModel
import com.example.myrefrig.ui.screens.recipes_screen.RecipesScreenViewModel
import com.example.myrefrig.ui.theme.MyRefrigTheme

/**
 * Factory class for creating ViewModel instances for RecipeModel.
 * @param application The application context to be used within the ViewModel.
 * Creates a new instance of the given ViewModel class.
 *@param modelClass The class for which a ViewModel instance needs to be created.
 *@return The newly created ViewModel instance.
 *@throws IllegalArgumentException If the given class is unknown.
 */
class RecipeModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipesScreenViewModel::class.java)) {
            return RecipesScreenViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


class HomeModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeScreenViewModel::class.java)) {
            return HomeScreenViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

/**

The main activity of the application.
Called when the activity is being created.

* @param savedInstanceState The saved instance state bundle.
*/
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: MainActivityViewModel by viewModels()


            val viewModelFactory = RecipeModelFactory(application)
            val recipesScreenViewModel: RecipesScreenViewModel =
                ViewModelProvider(this, viewModelFactory)[RecipesScreenViewModel::class.java]

            val homeModelFactory = HomeModelFactory(application)
            val homeScreenViewModel: HomeScreenViewModel =
                ViewModelProvider(this, homeModelFactory)[HomeScreenViewModel::class.java]

            MyRefrigTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,

                    ) {
                    //Calling the greeting method, that represents ongoing views, which explaining
                    //functions the app has
                    val navController = rememberNavController()

                    InitialNavigation(
                        navController = navController,
                        viewModel = viewModel,
                        recipesScreenViewModel,
                        homeScreenViewModel
                    )


                }
            }
        }
    }
}




