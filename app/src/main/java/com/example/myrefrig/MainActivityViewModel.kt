package com.example.myrefrig

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myrefrig.data.AlbumsDataProvider
import com.example.myrefrig.data.model.Album

class MainActivityViewModel : ViewModel() {
    private val _albumsLiveData = MutableLiveData<MutableList<Album>>()
    val albumLiveData : LiveData<MutableList<Album>>
    get() = _albumsLiveData


    init {
        getAlbums()
    }

    private fun getAlbums() {
        _albumsLiveData.value = AlbumsDataProvider.albums.take(3).toMutableList()
    }
}