package com.example.camerax.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.camerax.models.Album
import com.example.camerax.models.Photo
import com.example.camerax.use_cases.AddAlbum
import com.example.camerax.use_cases.AddPhotos
import com.example.camerax.use_cases.GetAlbums
import com.example.camerax.use_cases.GetPhotos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewmodel @Inject constructor(
    private val addAlbumUsecase: AddAlbum,
    private val addPhotosUsecase: AddPhotos,
    private val getAlbumsUsecase: GetAlbums,
    private val getPhotosUsecase: GetPhotos
) : ViewModel() {

    private val _uiToast = MutableSharedFlow<String>()
    val uiToast: SharedFlow<String> = _uiToast

    private var _photosStateFlow = MutableSharedFlow<List<Photo>>()
    val photosStateFlow : SharedFlow<List<Photo>> = _photosStateFlow

    private val photos = mutableListOf<Photo>()


    suspend fun getAllAlbums() = getAlbumsUsecase()

    suspend fun getPhotsos(albumName : String) = getPhotosUsecase(albumName)


    fun addPhotos(name: String, path: String) {
        viewModelScope.launch {
            photos.add(Photo(fileName = name, filePath = path))
            _photosStateFlow.emit(photos)
        }
    }

    fun saveAlbums(albumName: String) {
        viewModelScope.launch {
            when {
                albumName == "" -> {
                    _uiToast.emit("Enter a valid album name")
                }
                photos.size <= 0 -> {
                    _uiToast.emit("Take atleast one picture!")
                }
                else -> {
                    photos.map { it.albumName = albumName }
                    addAlbumUsecase(Album(albumName, photos[0].filePath))
                    addPhotosUsecase(photos)
                    photos.clear()
                }
            }
        }
    }
}