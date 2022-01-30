package com.example.gharmaiadmin.api

import com.example.gharmaiadmin.entity.AdminEntity
import com.example.gharmaiadmin.entity.UserEntity
import com.example.gharmaiadmin.response.AdminResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface AdminAPI {

    //user API
    //routes
    @POST("admin/register")
    suspend fun registerAdmin(
        @Body user: AdminEntity
    ): Response<AdminResponse>


    @FormUrlEncoded
    @POST("admin/login")
    suspend fun loginAdmin(
        //send parameters
//        @Body user: UserEntity
        @Field("adminEmail") email: String,
        @Field("adminPassword") password: String
    ): Response<AdminResponse>

    @GET("profile/single")
    suspend fun getAllUserAPI(
//        @Header("Authorization")token: String,
//        @Path("id")  id: String
    ): Response<AdminResponse>

    @FormUrlEncoded
    @PUT("user/update/{id}")
    suspend fun editUser(
        @Header("Authorization") token: String,
        @Path("id") id:String,
        @Field("username") username:String,
        @Field("email") email:String,
        @Field("address") address:String,
        @Field("phone") phone:String,
    ): Response<AdminResponse>
    @PUT("profile/update/{id}")
    suspend fun updateuser(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Body data : UserEntity
    ): Response<AdminResponse>


//    @Multipart
//    @PUT("profile/update/{id}")
//    suspend fun updateimage(
//        @Header("Authorization") token: String,
//        @Path("id") id: String,
//        @Part file: MultipartBody.Part
//    ): Response<UserResponse>

    @Multipart
    @PUT("profile/image/update/{id}")
    suspend fun updateimage(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Part file: MultipartBody.Part
    ): Response<AdminResponse>

    @DELETE("profile/delete/{id}")
    suspend fun deleteuser(
        @Header("Authorization") token: String,
        @Path("id") id: String,

        ):Response<AdminResponse>
}