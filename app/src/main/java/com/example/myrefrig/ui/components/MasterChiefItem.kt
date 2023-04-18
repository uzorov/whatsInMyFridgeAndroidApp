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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrefrig.data.model.Recipe

@Composable
fun MasterChiefItem(masterChiefRecipe: Recipe, itemSize: Dp) {
    Box(modifier = Modifier.padding(horizontal = 7.5.dp, vertical = 7.5.dp)) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(itemSize)
                .background(color = masterChiefRecipe.background_color)
        ) {


            Column(modifier = Modifier.align(Alignment.TopStart)) {

                Text(
                    masterChiefRecipe.title,
                    style = MaterialTheme.typography.h2,
                    fontSize = 18.sp,
                    lineHeight = 26.sp,
                    color = masterChiefRecipe.textColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )

                Text(
                    masterChiefRecipe.description,
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 12.sp,
                    color = masterChiefRecipe.textColor.copy(0.8f),
                )


            }

            Image(
                painter = painterResource(id = masterChiefRecipe.imageURL),
                contentDescription = "MasterChiefRecipes",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .width(80.dp)
                    .height(110.dp)
                    .padding(end = 5.dp)
            )
        }
    }
}