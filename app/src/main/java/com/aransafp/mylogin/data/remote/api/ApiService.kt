package com.aransafp.mylogin.data.remote.api

import com.aransafp.mylogin.data.remote.response.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getListUsers(): List<User>
}