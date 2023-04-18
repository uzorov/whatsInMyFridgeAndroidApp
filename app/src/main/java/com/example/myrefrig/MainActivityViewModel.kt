package com.example.myrefrig

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrefrig.data.AlbumsDataProvider
import com.example.myrefrig.data.BottomNavItemProvider
import com.example.myrefrig.data.model.Album
import com.example.myrefrig.data.model.BottomNavItem

class MainActivityViewModel : ViewModel() {
   private val _backgroundColor = MutableLiveData<Color>()
    val backgroundColor : LiveData<Color>
    get() = _backgroundColor

    private val _albumsLiveData = MutableLiveData<MutableList<Album>>()
    val albumLiveData : LiveData<MutableList<Album>>
    get() = _albumsLiveData

    private var _bottomItems : MutableList<BottomNavItem> = mutableListOf()
    val bottomItems : MutableList<BottomNavItem>
        get() = _bottomItems




    init {
        getAlbums()
        getBottomNavItems()
        _backgroundColor.value = Color.Black.copy(0.8F)
    }

    private fun getBottomNavItems() {
       _bottomItems = BottomNavItemProvider.bottomNavItems.toMutableList()
    }

    private fun getAlbums() {
        _albumsLiveData.value = AlbumsDataProvider.albums.toMutableList().asReversed()
    }

    fun updateBackgroundColor() {
        _backgroundColor.value = Color.Transparent
    }
}