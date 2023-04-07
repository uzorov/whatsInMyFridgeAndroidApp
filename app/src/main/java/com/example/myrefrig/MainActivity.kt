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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.consumePositionChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myrefrig.data.model.Album
import com.example.myrefrig.ui.theme.MyRefrigTheme
import com.example.myrefrig.util.orFalse
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val viewModel: MainActivityViewModel = viewModel()
            val kittens = viewModel.albumLiveData.observeAsState()

            val configuration = LocalConfiguration.current
            val screenHeight = configuration.screenHeightDp.dp
            val cardHeight = screenHeight - 200.dp

            MyRefrigTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val boxModifier = Modifier
                    Box(
                        modifier = boxModifier.fillMaxSize()
                    ) {
                        val listEmpty = remember {
                            mutableStateOf(false)
                        }
                        KittenLoader(modifier = boxModifier)

                        kittens.value?.forEachIndexed { index, album ->
                            DraggableCard(
                                item = album,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(cardHeight)
                                    .padding(
                                        top = 16.dp + (index + 2).dp,
                                        bottom = 16.dp,
                                        start = 16.dp,
                                        end = 16.dp
                                    ),

                                onSwiped = { _, swipedAlbum ->
                                    if (kittens.value?.isNotEmpty().orFalse()) {
                                        kittens.value?.remove(swipedAlbum)
                                        if (kittens.value?.isEmpty().orFalse()) {
                                            listEmpty.value = true
                                        }
                                    }
                                }
                            )
                            {
                                CardContent(album = album)
                            }
                        }

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = cardHeight)
                                .alpha(animateFloatAsState(if (listEmpty.value) 0f else 1f).value)
                        ) {
                            IconButton(
                                onClick = {
                                    /* TODO Hook to swipe event */
                                },
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colors.background)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    tint = Color.Gray,
                                    contentDescription = null,
                                    modifier = Modifier.size(36.dp)
                                )
                            }
                            IconButton(
                                onClick = {
                                    /* TODO Hook to swipe event */
                                },
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                                    .size(60.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colors.background)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = null,
                                    tint = Color.Red,
                                    modifier = Modifier.size(36.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }


    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")

    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyRefrigTheme {
            Greeting("Android")
        }
    }

    @Composable
    fun CardContent(album: Album) {
        Column {
            Image(
                painter = painterResource(album.imageId),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.weight(1f)
            )
            Row(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
                Text(
                    text = album.title,
                    style = typography.h6,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .weight(1f),
                    textAlign = TextAlign.Start
                )
                Icon(
                    imageVector = Icons.Outlined.Place,
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    contentDescription = null
                )
                Text(
                    text = "${Random.nextInt(1, 3)} km",
                    style = typography.body2,
                    color = Color.Green
                )
            }
        }
    }

    @Composable
    fun KittenLoader(modifier: Modifier) {
        Box(
            contentAlignment = Alignment.Center, modifier = modifier
                .fillMaxSize()
                .clip(CircleShape)
        ) {
            MultiStateAnimationCircleFilledCanvas(Color.Cyan, 400f)
            Image(
                painter = painterResource(id = R.drawable.kitten),
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }

    @Composable
    fun MultiStateAnimationCircleFilledCanvas(
        color: Color = Color.Green,
        radiusEnd: Float = 200f,
    ) {
        val transition = rememberInfiniteTransition()
        val floatAnim by transition.animateFloat(
            initialValue = 10f,
            targetValue = radiusEnd,
            animationSpec = infiniteRepeatable(tween(1200), RepeatMode.Reverse)
        )
        Canvas(modifier = Modifier.padding(16.dp)) {
            val centerOffset = Offset(10f, 10f)
            drawCircle(
                color = color.copy(alpha = 0.8f),
                radius = floatAnim,
                center = centerOffset,
            )
            drawCircle(
                color = color.copy(alpha = 0.4f),
                radius = floatAnim / 2,
                center = centerOffset,
            )
            drawCircle(
                color = color.copy(alpha = 0.2f),
                radius = floatAnim / 4,
                center = centerOffset,
            )
        }
    }

    enum class SwipeResult {
        ACCEPTED, REJECTED
    }

    @Composable
    fun DraggableCard(
        item: Any,
        modifier: Modifier = Modifier,
        onSwiped: (Any, Any) -> Unit,
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
                elevation = 16.dp,
                modifier = modifier
                    .dragContent(
                        swipeX = swipeX,
                        swipeY = swipeY,
                        maxX = swipeXRight,
                        onSwiped = { _, _ -> }
                    )
                    .graphicsLayer(
                        translationX = swipeX.value,
                        translationY = swipeY.value,
                        rotationZ = rotationFraction,
                    )
                    .clip(RoundedCornerShape(16.dp))
            ) {
                content()
            }
        } else {
            // on swiped
            val swipeResult =
                if (swipeX.value > 0) SwipeResult.ACCEPTED else SwipeResult.REJECTED
            onSwiped(swipeResult, item)
        }
    }

    fun Modifier.dragContent(
        swipeX: Animatable<Float, AnimationVector1D>,
        swipeY: Animatable<Float, AnimationVector1D>,
        maxX: Float,
        onSwiped: (Any, Any) -> Unit,
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
                                swipeX.animateTo(0f, tween(400))
                            }
                            launch {
                                swipeY.animateTo(0f, tween(400))
                            }
                        } else {
                            launch {
                                if (swipeX.targetValue > 0) {
                                    swipeX.animateTo(maxX, tween(400))
                                } else {
                                    swipeX.animateTo(-maxX, tween(400))
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
}

