package com.example.gharmaiadmin.response

import com.example.gharmaiadmin.entity.ServiceEntity

data class ServiceResponse(
    val success:Boolean? = null,
    val token: String? =null,
    val data: MutableList<ServiceEntity>? = null,
    val userId: String? = null,
) {
}