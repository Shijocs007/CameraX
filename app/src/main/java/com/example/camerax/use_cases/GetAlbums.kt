package com.example.camerax.use_cases

import com.example.camerax.models.Album
import com.example.camerax.repository.AlbumRepository
import kotlinx.coroutines.flow.Flow

class GetAlbums(private val repository: AlbumRepository) {
    suspend operator fun invoke(): Flow<List<Album>> {
        return repository.getAlbums()
    }
}