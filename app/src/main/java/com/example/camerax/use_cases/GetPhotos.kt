package com.example.camerax.use_cases

import com.example.camerax.repository.AlbumRepository
import com.example.camerax.room.relations.AlbumWithPhotos
import kotlinx.coroutines.flow.Flow

class GetPhotos(private val repository: AlbumRepository) {
    suspend operator fun invoke(albumName : String): Flow<AlbumWithPhotos> {
        return repository.getPhotos(albumName)
    }
}