package com.example.myrefrig

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrefrig.data.AlbumsDataProvider
import com.example.myrefrig.data.BottomNavItemProvider
import com.example.myrefrig.data.model.Album
import com.example.myrefrig.data.model.BottomNavItem

class MainActivityViewModel : ViewModel() {
    private val _albumsLiveData = MutableLiveData<MutableList<Album>>()
    val albumLiveData : LiveData<MutableList<Album>>
    get() = _albumsLiveData

    private var _bottomItems : MutableList<BottomNavItem> = mutableListOf()
    val bottomItems : MutableList<BottomNavItem>
        get() = _bottomItems


    init {
        getAlbums()
        getBottomNavItems()
    }

    private fun getBottomNavItems() {
       _bottomItems = BottomNavItemProvider.bottomNavItems.toMutableList().asReversed()
    }

    private fun getAlbums() {
        _albumsLiveData.value = AlbumsDataProvider.albums.toMutableList().asReversed()
    }
}