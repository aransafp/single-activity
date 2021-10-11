package com.aransafp.mylogin.data.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    companion object {
        const val KEY_LOGIN = "isLogin"
        const val KEY_USERNAME = "username"
    }

    private val preferences = context.getSharedPreferences("Session", Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = preferences.edit()

    fun createLoginSession() {
        editor.putBoolean(KEY_LOGIN, true)
            .apply()
    }

    fun logout() {
        editor.clear()
        editor.apply()
    }

    val isLogin: Boolean = preferences.getBoolean(KEY_LOGIN, false)

    fun saveToPreference(key: String, value: String) {
        editor.putString(key, value)
            .apply()
    }

    fun getFromPreference(key: String) = preferences.getString(key, "")

}