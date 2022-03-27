package com.example.camerax.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.camerax.models.Album
import com.example.camerax.models.Photo


@Database(entities = [Album::class, Photo::class], version = 1)
abstract class CameraDatabase : RoomDatabase() {
    abstract fun cameraDao() : CameraDao

    companion object {
        val DATABASE_NAME: String = "camerax_album_db"
    }
}