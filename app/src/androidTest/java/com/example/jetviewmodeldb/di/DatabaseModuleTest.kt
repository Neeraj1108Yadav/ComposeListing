package com.example.jetviewmodeldb.di

import android.content.Context
import androidx.room.Room
import com.example.jetviewmodeldb.db.AppDao
import com.example.jetviewmodeldb.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Named
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
object DatabaseModuleTest {

    @Singleton
    @Provides
    @Named("test_db")
    fun provideInMemoryDB(@ApplicationContext context: Context) : AppDatabase{
        return Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).build()
    }

    @Provides
    fun provideDbDao(database: AppDatabase):AppDao{
        return database.getDao()
    }

}