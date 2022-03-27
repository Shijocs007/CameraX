package com.example.camerax.room

import androidx.room.*
import com.example.camerax.models.Album
import com.example.camerax.models.Photo
import com.example.camerax.room.relations.AlbumWithPhotos
import kotlinx.coroutines.flow.Flow

@Dao
interface CameraDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPhotos(photos: List<Photo>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAlbum(album: Album)

    @Transaction
    @Query("SELECT * FROM photo")
    fun getAlbumWithPhotos(): Flow<List<AlbumWithPhotos>>

    @Query("SELECT * FROM album")
    fun getAlbums() : Flow<List<Album>>

    @Query("SELECT * FROM photo WHERE albumName = :albumName")
    fun getPhotos(albumName: String) : Flow<List<Photo>>
}