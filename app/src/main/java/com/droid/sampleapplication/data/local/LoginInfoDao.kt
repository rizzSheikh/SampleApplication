package com.droid.sampleapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginInfoDao {
    @Insert
    suspend fun insertLoginInfo(loginInfo: LoginInfo)

    @Query("SELECT * FROM LoginInfo LIMIT 1")
    suspend fun getLoginInfo(): LoginInfo?

    @Query("DELETE FROM LoginInfo")
    suspend fun deleteLoginInfo()
}