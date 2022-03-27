package com.example.camerax.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Photo(
    @PrimaryKey(autoGenerate = false)
    val fileName : String,
    val filePath : String,
    var albumName : String?= ""
)