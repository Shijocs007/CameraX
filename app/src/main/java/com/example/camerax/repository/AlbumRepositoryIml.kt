package com.example.camerax.repository

import com.example.camerax.models.Album
import com.example.camerax.models.Photo
import com.example.camerax.room.CameraDao
import com.example.camerax.room.relations.AlbumWithPhotos
import kotlinx.coroutines.flow.Flow

class AlbumRepositoryIml(private val dao : CameraDao) : AlbumRepository {
    override suspend fun insertPhotos(photos: List<Photo>) {
        dao.insertPhotos(photos)
    }

    override suspend fun insertAlbum(album: Album) {
        dao.insertAlbum(album)
    }

    override suspend fun getAlbumsWithPhotos(): Flow<List<AlbumWithPhotos>> {
       return dao.getAlbumWithPhotos()
    }

    override suspend fun getPhotos(albumName: String): Flow<List<Photo>> {
        return dao.getPhotos(albumName)
    }

}