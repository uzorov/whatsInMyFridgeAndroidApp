package com.example.myrefrig

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myrefrig.data.model.Album
import com.example.myrefrig.util.orFalse
import kotlinx.coroutines.launch
import kotlin.math.abs


/*
    Method that displays greeting cards with description of app`s functionality
     */
@Composable
fun Greeting(viewModel: MainActivityViewModel, navController: NavController) {

    val ongoingViews = viewModel.albumLiveData.observeAsState()
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    val backgroundColor = viewModel.backgroundColor.observeAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor.value!!)
    ) {


        ongoingViews.value?.forEachIndexed { index, album ->
            DraggableCard(
                item = album,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screenHeight + 10.dp)
                    .padding(
                        top = 16.dp + (index + 2).dp,
                        start = 8.dp,
                        end = 8.dp,
                    ),

                onSwiped = { swipedAlbum ->
                    if (ongoingViews.value?.isNotEmpty().orFalse()) {
                        ongoingViews.value?.remove(swipedAlbum)
                    }
                    else
                    {
                        viewModel.updateBackgroundColor()
                        navController.navigate("scaffold")
                    }
                }
            )
            {
                CardContent(album = album)
            }
        }
    }

}

//The filling of card
//Its essential that method is inside the MainActivity class
//because it has to call getResources() method
@Composable
fun CardContent(album: Album) {
    Box(
        modifier = Modifier.background(album.backgroundColor),
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

//Draggable card that has some passed content to display
@Composable
fun DraggableCard(
    item: Any,
    modifier: Modifier = Modifier,
    onSwiped: (Any) -> Unit,
    content: @Composable () -> Unit,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val swipeXLeft = -(screenWidth.value * 3.2).toFloat()
    val swipeXRight = (screenWidth.value * 3.2).toFloat()
    val swipeYTop = -1000f
    val swipeYBottom = 1000f
    val swipeX = remember { Animatable(0f) }
    val swipeY = remember { Animatable(0f) }
    swipeX.updateBounds(swipeXLeft, swipeXRight)
    swipeY.updateBounds(swipeYTop, swipeYBottom)
    if (abs(swipeX.value) < swipeXRight - 50f) {
        val rotationFraction = (swipeX.value / 60).coerceIn(-40f, 40f)
        Card(
            elevation = 4.dp,
            modifier = modifier
                .dragContent(
                    swipeX = swipeX,
                    swipeY = swipeY,
                    maxX = swipeXRight,
                    onSwiped = { _ -> }
                )
                .graphicsLayer(
                    translationX = swipeX.value,
                    translationY = swipeY.value,
                    rotationZ = rotationFraction,
                )
                .clip(RoundedCornerShape(30.dp))

        ) {
            content()
        }
    } else {
        // on swiped
        onSwiped(item)
    }
}

fun Modifier.dragContent(
    swipeX: Animatable<Float, AnimationVector1D>,
    swipeY: Animatable<Float, AnimationVector1D>,
    maxX: Float,
    onSwiped: (Any) -> Unit,
): Modifier = composed {
    val coroutineScope = rememberCoroutineScope()
    pointerInput(Unit) {
        this.detectDragGestures(
            onDragCancel = {
                coroutineScope.apply {
                    launch { swipeX.animateTo(0f) }
                    launch { swipeY.animateTo(0f) }
                }
            },
            onDragEnd = {
                coroutineScope.apply {
                    // if it's swiped 1/4th
                    if (abs(swipeX.targetValue) < abs(maxX) / 4) {
                        launch {
                            swipeX.animateTo(0f, tween(200))
                        }
                        launch {
                            swipeY.animateTo(0f, tween(200))
                        }
                    } else {
                        launch {
                            if (swipeX.targetValue > 0) {
                                swipeX.animateTo(maxX, tween(200))
                            } else {
                                swipeX.animateTo(-maxX, tween(200))
                            }
                        }
                    }
                }
            }
        ) { change, dragAmount ->
            change.consumePositionChange()
            coroutineScope.apply {
                launch { swipeX.animateTo(swipeX.targetValue + dragAmount.x) }
                launch { swipeY.animateTo(swipeY.targetValue + dragAmount.y) }
            }
        }
    }
}


