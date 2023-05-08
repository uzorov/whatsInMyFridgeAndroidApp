package com.example.myrefrig

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrefrig.data.AlbumsDataProvider
import com.example.myrefrig.data.BottomNavItemProvider
import com.example.myrefrig.data.model.Album
import com.example.myrefrig.data.model.BottomNavItem

/**

* ViewModel for the MainActivity. Responsible for providing data to the UI, such as the background color and the list of albums and bottom navigation items.
 */
class MainActivityViewModel : ViewModel() {
    /**

    * The background color of the UI. */
    private val _backgroundColor = MutableLiveData<Color>()
    /**
    * LiveData representing the background color of the UI. */
    val backgroundColor : LiveData<Color>
    get() = _backgroundColor

    /**
    LiveData representing the list of albums. */
    private val _albumsLiveData = MutableLiveData<MutableList<Album>>()
    val albumLiveData : LiveData<MutableList<Album>>
    get() = _albumsLiveData

    private var _bottomItems : MutableList<BottomNavItem> = mutableListOf()
    val bottomItems : MutableList<BottomNavItem>
        get() = _bottomItems



    /**

    Retrieves the list of bottom navigation items. */
    init {
        getAlbums()
        getBottomNavItems()
        _backgroundColor.value = Color.Black.copy(0.8F)
    }

    /**

    Retrieves the list of bottom navigation items from BottomNavItemProvider. */
    private fun getBottomNavItems() {
       _bottomItems = BottomNavItemProvider.bottomNavItems.toMutableList()
    }

    /**

    Retrieves the list of albums from AlbumsDataProvider and reverses its order. */
    private fun getAlbums() {
        _albumsLiveData.value = AlbumsDataProvider.albums.toMutableList().asReversed()
    }

    /**

    Sets the background color of the UI to transparent. */
    fun updateBackgroundColor() {
        _backgroundColor.value = Color.Transparent
    }
}