package com.droid.sampleapplication.di

import android.content.Context
import androidx.room.Room
import com.droid.sampleapplication.data.local.LoginInfoDao
import com.droid.sampleapplication.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()
    }

    @Provides
    fun provideLoginInfoDao(database: AppDatabase): LoginInfoDao {
        return database.loginInfoDao()
    }
}