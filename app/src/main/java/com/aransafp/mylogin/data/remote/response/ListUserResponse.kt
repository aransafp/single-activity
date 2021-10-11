package com.aransafp.mylogin.data.remote.response

import com.google.gson.annotations.SerializedName

data class ListUserResponse(

	@SerializedName("ListUserResponse")
	val userResponse: List<User>
)

data class User(

	@SerializedName("username")
	val username: String
)

