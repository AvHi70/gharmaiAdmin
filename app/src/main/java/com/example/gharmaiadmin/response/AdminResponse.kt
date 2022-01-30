package com.example.gharmaiadmin.response

import com.example.gharmaiadmin.entity.AdminEntity

//it receives response from api for sign in/up


data class AdminResponse(
    val success:Boolean? = null,
    val token: String? =null,
    val data: AdminEntity? = null,
//    val data: MutableList<UserEntity>? = null,
    val userId: String? = null,
) {
}