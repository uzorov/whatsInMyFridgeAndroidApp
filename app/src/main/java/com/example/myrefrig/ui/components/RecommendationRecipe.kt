package com.example.myrefrig.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrefrig.data.model.Recipe

@Composable
fun RecipeItem(recommendationRecipe: Recipe) {

    BoxWithConstraints(
        modifier = Modifier
            .padding(end = 7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(recommendationRecipe.background_color)
            .wrapContentHeight()
            .wrapContentWidth()
    ) {


        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .wrapContentHeight()
                .padding(horizontal = 8.dp)

                .fillMaxSize(),

            ) {


            Box(
                modifier = Modifier
                    .fillMaxSize()

                    .clip(RoundedCornerShape(10.dp))

            ) {
                Image(
                    painter = painterResource(id = recommendationRecipe.imageURL),
                    contentDescription = "Recommendation Image",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    alignment = Alignment.Center

                )
            }

            Text(
                text = recommendationRecipe.title,
                style = MaterialTheme.typography.h6,
                color = recommendationRecipe.textColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 5.dp)
            )
            Text(
                modifier = Modifier.padding(bottom = 10.dp),
                text = recommendationRecipe.description,
                color = recommendationRecipe.textColor.copy(0.9f),
                style = MaterialTheme.typography.body1,
                fontSize = 10.sp
            )
        }
    }
}