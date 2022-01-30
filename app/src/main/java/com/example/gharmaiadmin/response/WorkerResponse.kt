package com.example.gharmaiadmin.response

import com.example.gharmaiadmin.entity.WorkerEntity

//it receives response from api for sign in/up


data class WorkerResponse(
    val success:Boolean? = null,
    val token: String? =null,
    val data: MutableList<WorkerEntity>? = null,
    val userId: String? = null,
) {
}