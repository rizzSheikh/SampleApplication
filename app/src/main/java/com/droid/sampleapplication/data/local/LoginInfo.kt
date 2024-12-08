package com.droid.sampleapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoginInfo")
data class LoginInfo(
    @PrimaryKey
    val userName: String,
    val isLoggedIn: Boolean
)
