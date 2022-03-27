package com.example.camerax.di

import android.content.Context
import androidx.room.Room
import com.example.camerax.room.CameraDao
import com.example.camerax.room.CameraDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    /**
     *this method provide CameraDatabase instance in application scope
     *
     * @param context  ApplicationContext
     * @return  the database instance of the application, CameraDatabase
     **/
    @Provides
    fun provideDb(@ApplicationContext context: Context) : CameraDatabase {
        return  Room
            .databaseBuilder(
                context,
                CameraDatabase::class.java,
                CameraDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    /**
     * this method provides the DAO instance of room database
     *
     * @param database room database instance
     * @return the instance of CameraDao
     * */
    @Provides
    fun provideDAO(database: CameraDatabase): CameraDao {
        return database.cameraDao()
    }
}