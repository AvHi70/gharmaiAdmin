package com.example.gharmaiadmin.entity

import android.os.Parcel
import android.os.Parcelable

data class UserEntity(

    val _id: String? = null,
    val username: String?= null,
    val addressUser: String?= null,
    val phoneUser: String?= null,
    val emailUser: String?= null,
    val passwordUser: String?= null,
    val genderUser: String?= null,
    var profile_picUser: String?=null
)