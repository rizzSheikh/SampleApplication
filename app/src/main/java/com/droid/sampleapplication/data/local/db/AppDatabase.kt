package com.droid.sampleapplication.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.droid.sampleapplication.data.local.LoginInfo
import com.droid.sampleapplication.data.local.LoginInfoDao

@Database(entities = [LoginInfo::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun loginInfoDao(): LoginInfoDao
}