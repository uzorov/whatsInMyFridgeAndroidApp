package com.example.myrefrig


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
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewmodel.compose.viewModel
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
                    color = MaterialTheme.colors.background
                ) {
                    //Calling the greeting method, that represents ongoing views, which explaining
                    //functions the app has
                    Greeting(viewModel)
                }
            }
        }
    }


    /*
    Method that displays greeting cards with description of app`s functionality
     */
    @Composable
    fun Greeting(viewModel: MainActivityViewModel) {

        val ongoingViews = viewModel.albumLiveData.observeAsState()
        val configuration = LocalConfiguration.current
        val screenHeight = configuration.screenHeightDp.dp
        val cardHeight = screenHeight

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            val listEmpty = remember {
                mutableStateOf(false)
            }
            //KittenLoader(modifier = boxModifier)

            ongoingViews.value?.forEachIndexed { index, album ->
                DraggableCard(
                    item = album,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(cardHeight)
                        .padding(
                            top = 16.dp + (index + 2).dp,
                            //bottom = 16dp,
                            start = 8.dp,
                            end = 8.dp
                        ),

                    onSwiped = { swipedAlbum ->
                        if (ongoingViews.value?.isNotEmpty().orFalse()) {
                            ongoingViews.value?.remove(swipedAlbum)
                            if (ongoingViews.value?.isEmpty().orFalse()) {
                                listEmpty.value = true
                            }
                        }
                    }
                )
                {
                    CardContent(album = album)
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

    //The filling of card
    //Its essential that method is inside the MainActivity class
    //because it has to call getResources() method
    @Composable
    fun CardContent(album: Album) {
        Box(
            modifier = Modifier.background(Color(resources.getColor(album.backgroundId))),
            contentAlignment = Alignment.Center
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {


                Image(
                    painter = painterResource(album.imageId),
                    contentScale = ContentScale.Fit,
                    contentDescription = null,
                    modifier = Modifier.size(180.dp)
                )
                Text(

                    text = album.title,
                    color = Color.White,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center
                )
                Text(

                    text = album.description,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Cursive,
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Left
                )


            }
        }
    }
}

