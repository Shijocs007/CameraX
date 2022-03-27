package com.example.camerax.use_cases

import com.example.camerax.models.Album
import com.example.camerax.repository.AlbumRepository

class AddAlbum(private val repository: AlbumRepository) {
    suspend operator fun invoke(album: Album) {
        repository.insertAlbum(album)
    }
}