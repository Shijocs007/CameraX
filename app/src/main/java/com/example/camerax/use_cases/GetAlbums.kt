package com.example.camerax.use_cases

import com.example.camerax.models.Album
import com.example.camerax.repository.AlbumRepository
import com.example.camerax.room.relations.AlbumWithPhotos
import kotlinx.coroutines.flow.Flow

class GetAlbums(private val repository: AlbumRepository) {
    suspend operator fun invoke(): Flow<List<AlbumWithPhotos>> {
        return repository.getAlbumsWithPhotos()
    }
}