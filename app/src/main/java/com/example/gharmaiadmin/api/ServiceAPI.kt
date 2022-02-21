package com.example.gharmaiadmin.api

import com.example.gharmaiadmin.entity.ServiceEntity
import com.example.gharmaiadmin.response.DeleteResponse
import com.example.gharmaiadmin.response.ServiceResponse
import com.example.gharmaiadmin.response.UserResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

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
        @Header("Authorization")token: String,
//        @Path("id") id: String,
    ): Response<ServiceResponse>

    @DELETE("admin/service/delete/{id}")
    suspend fun deleteService(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Response<DeleteResponse>

    @Multipart
    @PUT("service/image/update/{id}")
    suspend fun updateimage(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Part file: MultipartBody.Part
    ): Response<ServiceResponse>
}