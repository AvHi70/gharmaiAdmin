package com.example.gharmaiadmin.repository

import com.example.gharmaiadmin.api.ApiRequest
import com.example.gharmaiadmin.api.ServiceBuilder
import com.example.gharmaiadmin.api.UserAPI
import com.example.gharmaiadmin.entity.UserEntity
import com.example.gharmaiadmin.response.UserResponse
import okhttp3.MultipartBody

class UserRepository : ApiRequest(){

    private val userApi =
        ServiceBuilder.buildService(UserAPI::class.java)

    //Register user
//    suspend fun registerUser(user: UserEntity): UserResponse {
//        return apiRequest {
//            userApi.registerUser(user)
//        }
//    }
//    // Login user
//    suspend fun login(email: String, password: String): UserResponse {
//        return apiRequest {
//            userApi.loginUser(email, password)
//        }
//    }
    suspend fun getAllUsers(): UserResponse {
        return apiRequest {
//            userApi.getAllUserAPI(ServiceBuilder.token!!, id)
            userApi.getAllUserAPI()
        }
    }
    suspend fun editUser(id: String,username: String, email: String,address: String,phone:String): UserResponse {
        return apiRequest {
            userApi.editUser(ServiceBuilder.token!!,id, username,  email,address,phone,)
        }
    }
    suspend fun updateuser(id:String, data: UserEntity): UserResponse {
        return apiRequest {
            userApi.updateuser(ServiceBuilder.token!!, id, data)
        }
    }
    suspend fun updateimage(id:String,body: MultipartBody.Part): UserResponse {
        return apiRequest {
            userApi.updateimage(ServiceBuilder.token!!, id, body)
        }
    }
    suspend fun deleteuser(id:String): UserResponse {
        return apiRequest {
            userApi.deleteuser(ServiceBuilder.token!!, id)
        }
    }
//    suspend fun getUserDetails(id:String): UserResponse {
//        return apiRequest {
//            userApi.getAllUserAPI(ServiceBuilder.token!!, id)
//        }
//    }
}