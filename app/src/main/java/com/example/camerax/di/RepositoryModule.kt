package com.example.camerax.di

import com.example.camerax.repository.AlbumRepository
import com.example.camerax.repository.AlbumRepositoryIml
import com.example.camerax.room.CameraDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class RepositoryModule {
    @Provides
    fun provideAlbumRepository(dao : CameraDao): AlbumRepository {
        return AlbumRepositoryIml(dao)
    }
}