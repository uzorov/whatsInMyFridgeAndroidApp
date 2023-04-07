package com.example.myrefrig


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.myrefrig.data.model.Album
import com.example.myrefrig.ui.theme.MyRefrigTheme
import com.example.myrefrig.util.orFalse
import kotlinx.coroutines.launch
import kotlin.math.abs


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: MainActivityViewModel = viewModel()

            MyRefrigTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,

                ) {
                    //Calling the greeting method, that represents ongoing views, which explaining
                    //functions the app has




                    val navController = rememberNavController()



                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                items = viewModel.bottomItems,
                                navController = navController,
                                OnItemClick = {
                                    navController.navigate(it.route)
                                })
                        },

                        content = {


                            Box(modifier = Modifier.padding(it)) {
                                Navigation(navController = navController)
                            }


                        }
                    )

                    Greeting(viewModel = viewModel)
                }
            }
        }
    }




    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyRefrigTheme {
            val viewModel: MainActivityViewModel = viewModel()
            Greeting(viewModel = viewModel)
        }
    }
}




