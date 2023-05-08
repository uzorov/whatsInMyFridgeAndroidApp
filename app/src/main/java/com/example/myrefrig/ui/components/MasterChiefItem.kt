package com.example.myrefrig.ui.components

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myrefrig.data.model.Recipe
import com.example.myrefrig.ui.theme.Gray

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MasterChiefItem(masterChiefRecipe: Recipe, itemSize: Dp, modifier: Modifier) {
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(itemSize)
                .background(color = Gray)
        ) {


            Column(modifier = Modifier.align(Alignment.TopStart)) {

                Text(
                    masterChiefRecipe.title,
                    style = MaterialTheme.typography.h2,
                    fontSize = 18.sp,
                    color = masterChiefRecipe.textColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )

                Text(
                    masterChiefRecipe.description,
                    modifier = Modifier.padding(start = 10.dp),
                    fontSize = 12.sp,
                    maxLines = 2,
                    color = masterChiefRecipe.textColor.copy(0.8f),
                )

                GlideImage(
                    model = masterChiefRecipe.imageURL,
                    contentDescription = "MasterChiefRecipes",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.End)
                        .width(80.dp)
                        .height(110.dp)
                        .padding(5.dp)
                        .clip(RoundedCornerShape(15.dp))
                )
            }


        }
    }
}