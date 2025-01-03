package com.example.jetviewmodeldb.di

import android.content.Context
import androidx.room.Room
import com.example.jetviewmodeldb.db.AppDao
import com.example.jetviewmodeldb.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "ToDo"
        ).build()
    }

    @Provides
    fun provideAppDao(appDatabase: AppDatabase) : AppDao{
        return appDatabase.getDao()
    }
}