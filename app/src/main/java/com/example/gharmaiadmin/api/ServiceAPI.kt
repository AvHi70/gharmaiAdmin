package com.example.gharmaiadmin.api

import com.example.gharmaiadmin.entity.ServiceEntity
import com.example.gharmaiadmin.response.ServiceResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ServiceAPI {

    //user API
    //routes
    @POST("service/insert")
    //suspend function to work with coroutines
    suspend fun registerService(
        //send user objects of type User class
        @Body user: ServiceEntity
    ): Response<ServiceResponse>

    @GET("service/showall")
    suspend fun getAllServiceAPI(
//        @Header("Authorization")token: String
    ): Response<ServiceResponse>
}