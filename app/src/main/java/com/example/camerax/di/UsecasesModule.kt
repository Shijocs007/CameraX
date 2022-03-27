package com.example.camerax.di

import com.example.camerax.repository.AlbumRepository
import com.example.camerax.use_cases.AddAlbum
import com.example.camerax.use_cases.AddPhotos
import com.example.camerax.use_cases.GetAlbums
import com.example.camerax.use_cases.GetPhotos
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UsecasesModule {

    @Provides
    fun provideAddAlbum(repository: AlbumRepository): AddAlbum {
        return AddAlbum(repository)
    }

    @Provides
    fun provideAddPhotos(repository: AlbumRepository): AddPhotos {
        return AddPhotos(repository)
    }

    @Provides
    fun provideGetAlbum(repository: AlbumRepository): GetAlbums {
        return GetAlbums(repository)
    }

    @Provides
    fun provideGetPhotos(repository: AlbumRepository): GetPhotos {
        return GetPhotos(repository)
    }
}