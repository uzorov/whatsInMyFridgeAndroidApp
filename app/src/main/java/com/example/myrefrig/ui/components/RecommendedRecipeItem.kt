package com.example.myrefrig.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myrefrig.data.model.Recipe

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun RecommendedRecipeItem(recommendationRecipe: Recipe, modifier: Modifier) {

    BoxWithConstraints(
        modifier = modifier
    ) {


        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 8.dp)
                .height(250.dp)
                .fillMaxSize(),

            ) {


            GlideImage(
                model = recommendationRecipe.imageURL,
                contentDescription = "Recommendation Image",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(4.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center

            )


            Text(
                text = recommendationRecipe.title,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 5.dp)
                    .width(150.dp)
            )
            Text(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .width(120.dp),
                text = recommendationRecipe.description,
                maxLines = 4,
                color = Color.Black.copy(0.9f),
                style = MaterialTheme.typography.body1,
                fontSize = 10.sp
            )

        }
    }
}