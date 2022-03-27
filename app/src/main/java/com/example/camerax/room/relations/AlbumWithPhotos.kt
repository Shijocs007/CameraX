package com.example.camerax.room.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.camerax.models.Album
import com.example.camerax.models.Photo

data class AlbumWithPhotos(
    @Embedded val album : Album,
    @Relation(
        parentColumn = "albumName",
        entityColumn = "albumName"
    )
    val photos: List<Photo>
)
