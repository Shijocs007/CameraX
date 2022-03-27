package com.example.camerax.repository

import com.example.camerax.models.Album
import com.example.camerax.models.Photo
import com.example.camerax.room.relations.AlbumWithPhotos
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {

    suspend fun insertPhotos(photos : List<Photo>)
    suspend fun insertAlbum(album : Album)
    suspend fun getAlbums() : Flow<List<Album>>
    suspend fun getPhotos(albumName : String) : Flow<AlbumWithPhotos>
}