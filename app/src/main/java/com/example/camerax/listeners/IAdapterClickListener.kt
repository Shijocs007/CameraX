package com.example.camerax.listeners

import com.example.camerax.models.Photo

interface IAdapterClickListener {

    fun onPhotoClcicked(filePath: String) {}
    fun onAlbumClicked(albumName : String) {}
    fun onRemovePhoto(photo: Photo) {}
}