package com.example.jetviewmodeldb

import androidx.test.filters.SmallTest
import com.example.jetviewmodeldb.db.AppDao
import com.example.jetviewmodeldb.db.AppDatabase
import com.example.jetviewmodeldb.di.DatabaseModule
import com.example.jetviewmodeldb.models.TaskModel
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@UninstallModules(DatabaseModule::class)
@HiltAndroidTest
@SmallTest
class AppDaoTest {

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("test_db")
    lateinit var appDatabase: AppDatabase

    @Inject
    lateinit var appDao: AppDao

    @Before
    fun setup(){
        hiltRule.inject()
    }

    @After
    fun tearDown(){
        appDatabase.close()
    }

    @Test
    fun insert_task() = runTest {
        val task = TaskModel(task = "This is test task")
        appDao.insertTask(task)

        val allTask = appDao.getAllTask()
        allTask.collect{
            assertThat(it).contains(task)
        }
    }
}