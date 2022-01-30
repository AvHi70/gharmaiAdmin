package com.example.gharmaiadmin.response

import com.example.gharmaiadmin.entity.UserEntity

//it receives response from api for sign in/up


data class UserResponse(
    val success:Boolean? = null,
    val token: String? =null,
    val data: MutableList<UserEntity>? = null,
    val userId: String? = null,
) {
}
