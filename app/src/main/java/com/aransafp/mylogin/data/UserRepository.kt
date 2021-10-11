package com.aransafp.mylogin.data

import com.aransafp.mylogin.data.sharedpreference.SessionManager

class UserRepository(private val sesi: SessionManager) {

    companion object {
        @Volatile
        private var INSTANCE: UserRepository? = null

        fun getInstance(sesi: SessionManager): UserRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: UserRepository(sesi)
            }

    }

    fun loginUser(username: String) {
        sesi.createLoginSession()
        sesi.saveToPreference(SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = sesi.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = sesi.isLogin

    fun logout() = sesi.logout()

}