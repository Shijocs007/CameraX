package com.example.camerax.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Album(
    @PrimaryKey(autoGenerate = false)
    val albumName : String,
    var thumbNail : String? = null
    )
