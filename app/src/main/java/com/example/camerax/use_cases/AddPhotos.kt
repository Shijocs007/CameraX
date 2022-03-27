package com.example.camerax.use_cases

import com.example.camerax.models.Photo
import com.example.camerax.repository.AlbumRepository

class AddPhotos(private val repository: AlbumRepository) {
    suspend operator fun invoke(photos: List<Photo>) {
        repository.insertPhotos(photos)
    }
}