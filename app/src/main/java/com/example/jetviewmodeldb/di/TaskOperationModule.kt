package com.example.jetviewmodeldb.di

import com.example.jetviewmodeldb.repo.TaskOperationListener
import com.example.jetviewmodeldb.repo.TaskOperationsRepo
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class TaskOperationModule {

    @Singleton
    @Binds
    abstract fun bindTaskOperationRepo(taskOperationsRepo: TaskOperationsRepo):TaskOperationListener
}