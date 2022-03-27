package com.example.camerax.listeners

import com.example.camerax.models.Photo

interface IAdapterClickListener {

    fun onPhotoClcicked(photo: Photo)
    fun onAlbumClicked(albumName : String)
}