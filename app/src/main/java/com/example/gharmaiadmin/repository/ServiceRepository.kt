package com.example.gharmaiadmin.repository

import com.example.gharmaiadmin.api.ApiRequest
import com.example.gharmaiadmin.api.ServiceAPI
import com.example.gharmaiadmin.api.ServiceBuilder
import com.example.gharmaiadmin.entity.ServiceEntity
import com.example.gharmaiadmin.response.DeleteResponse
import com.example.gharmaiadmin.response.ServiceResponse
import com.example.gharmaiadmin.response.UserResponse
import okhttp3.MultipartBody

class ServiceRepository: ApiRequest() {

    private val serviceAPI =
        ServiceBuilder.buildService(ServiceAPI::class.java)


    suspend fun registerService(service: ServiceEntity): ServiceResponse {
        return apiRequest {
            serviceAPI.registerService(service)
        }
    }

    suspend fun getAllServiceAPI(): ServiceResponse {
        return apiRequest {
//            serviceAPI.getAllServiceAPI()
            serviceAPI.getAllServiceAPI(ServiceBuilder.token!!)
        }
    }
    suspend fun deleteService(id: String): DeleteResponse {
        return apiRequest {
            serviceAPI.deleteService(ServiceBuilder.token!!,id)
        }
    }
    suspend fun updateimage(id:String,body: MultipartBody.Part): ServiceResponse {
        return apiRequest {
            serviceAPI.updateimage(ServiceBuilder.token!!, id, body)
        }
    }
}