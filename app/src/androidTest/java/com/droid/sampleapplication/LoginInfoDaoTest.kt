package com.droid.sampleapplication

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.droid.sampleapplication.data.local.LoginInfo
import com.droid.sampleapplication.data.local.LoginInfoDao
import com.droid.sampleapplication.data.local.db.AppDatabase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class LoginInfoDaoTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var appDatabase: AppDatabase

    private lateinit var loginInfoDao: LoginInfoDao

    @Before
    fun setup() {
        hiltRule.inject()
        loginInfoDao = appDatabase.loginInfoDao()
    }

    @Test
    fun testDeleteAll() = runBlocking {
        // Insert test data
        val loginInfo1 = LoginInfo(userName = "user1", isLoggedIn = true)
        loginInfoDao.insertLoginInfo(loginInfo1)

        // Verify data is inserted
        var loginInfo = loginInfoDao.getLoginInfo()
        assertEquals("user1", loginInfo?.userName)

        // Delete all data
        loginInfoDao.deleteLoginInfo()

        // Verify table is empty
        loginInfo = loginInfoDao.getLoginInfo()
        assertEquals(null, loginInfo)
    }

}