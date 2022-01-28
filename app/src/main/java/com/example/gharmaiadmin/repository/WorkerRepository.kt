package com.example.gharmaiadmin.repository

import com.example.gharmaiadmin.api.ApiRequest
import com.example.gharmaiadmin.api.ServiceBuilder
import com.example.gharmaiadmin.api.WorkerAPI
import com.example.gharmaiadmin.entity.WorkerEntity
import com.example.gharmaiadmin.response.WorkerResponse
import okhttp3.MultipartBody

class WorkerRepository : ApiRequest(){

    private val workerApi =
        ServiceBuilder.buildService(WorkerAPI::class.java)

    //Register worker
    suspend fun registerWorker(worker: WorkerEntity): WorkerResponse {
        return apiRequest {
            workerApi.registerUser(worker)
        }
    }
    // Login worker
    suspend fun loginWorker(email: String, password: String): WorkerResponse {
        return apiRequest {
            workerApi.loginWorker(email, password)
        }
    }
    suspend fun getCurrentWorker(id: String): WorkerResponse {
        return apiRequest {
            workerApi.getWorkerProfile(ServiceBuilder.token!!, id)
        }
    }
//    suspend fun editUser(id: String,username: String, email: String,address: String,phone:String): UserResponse {
//        return apiRequest {
//            userApi.editUser(ServiceBuilder.token!!,id, username,  email,address,phone,)
//        }
//    }
    suspend fun updateWorker(id:String, data: WorkerEntity): WorkerResponse {
        return apiRequest {
            workerApi.updateWorker(ServiceBuilder.token!!, id, data)
        }
    }
//    suspend fun updateimage(id:String,body: MultipartBody.Part): UserResponse {
//        return apiRequest {
//            userApi.updateimage(ServiceBuilder.token!!, id, body)
//        }
//    }
//    suspend fun deleteuser(id:String): UserResponse {
//        return apiRequest {
//            userApi.deleteuser(ServiceBuilder.token!!, id)
//        }
//    }suspend fun getUserDetails(id:String): UserResponse {
//        return apiRequest {
//            userApi.getAllUserAPI(ServiceBuilder.token!!, id)
//        }
//    }
}