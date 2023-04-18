package com.example.myrefrig.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myrefrig.R
import com.example.myrefrig.data.model.Recipe
import com.example.myrefrig.ui.theme.DeepBlue
import com.example.myrefrig.ui.theme.TextWhite

@Composable
fun BestRecipeItem(
    bestRecipe: Recipe,
    modifier: Modifier = Modifier,
    textColor: Color,
) {
    BoxWithConstraints(
        modifier = modifier
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight


        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {


            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 15.dp, end = 5.dp, bottom = 5.dp, top = 5.dp)
            ) {


                Row() {
                    Text(
                        text = bestRecipe.title,
                        style = MaterialTheme.typography.h6,
                        color = textColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.weight(0.6f)
                    )

                    Image(
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = bestRecipe.imageURL),
                        contentDescription = bestRecipe.title,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .weight(0.4f),
                        alignment = Alignment.TopEnd

                    )
                }






                Text(
                    text = bestRecipe.description,
                    color = textColor,
                    style = MaterialTheme.typography.body1,
                    fontSize = 12.sp
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(bottom = 15.dp, start = 15.dp, end = 15.dp),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = bestRecipe.calories.toString() + " КК",
                        color = textColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.Open),
                        color = TextWhite,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .clickable {
                                // Handle the click
                            }
                            .clip(RoundedCornerShape(12.dp))
                            .background(DeepBlue)
                            .padding(vertical = 6.dp, horizontal = 15.dp)
                    )
                }
            }


        }
    }
}