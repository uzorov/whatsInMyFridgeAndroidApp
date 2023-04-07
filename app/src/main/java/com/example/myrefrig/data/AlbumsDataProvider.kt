package com.example.myrefrig.data

import com.example.myrefrig.R
import com.example.myrefrig.data.model.Album

object AlbumsDataProvider {
    val albums = mutableListOf<Album>(
        Album(
            id =1,
            title = "The really cute kitty cat",
            description = "So much cute kitten",
            imageId = R.drawable.catt
        ),
        Album(
            id =1,
            title = "Another cute kitty cat",
            description = "So much cute kitten",
            imageId = R.drawable.cattt
        ),
        Album(
            id =1,
            title = "One more cute kitty cat",
            description = "So much cute kitten",
            imageId = R.drawable.kitten
        )

    )
}