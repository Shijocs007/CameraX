package com.example.camerax.room

import androidx.room.*
import com.example.camerax.models.Album
import com.example.camerax.models.Photo
import com.example.camerax.room.relations.AlbumWithPhotos

@Dao
interface CameraDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPhoto(school: Photo)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlbum(school: Album)

    @Transaction
    @Query("SELECT * FROM photo WHERE albumName = :albumName")
    suspend fun getAlbumWithPhotos(albumName: String): List<AlbumWithPhotos>
}