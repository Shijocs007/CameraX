package com.example.camerax.viewmodels

import androidx.lifecycle.ViewModel
import com.example.camerax.use_cases.AddAlbum
import com.example.camerax.use_cases.AddPhotos
import com.example.camerax.use_cases.GetAlbums
import com.example.camerax.use_cases.GetPhotos
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumViewmodel @Inject constructor(
    private val addAlbumUsecase: AddAlbum,
    private val addPhotosUsecase: AddPhotos,
    private val getAlbumsUsecase: GetAlbums,
    private val getPhotosUsecase: GetPhotos
) : ViewModel() {

}