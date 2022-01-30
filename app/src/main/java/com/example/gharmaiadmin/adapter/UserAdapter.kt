package com.example.gharmaiadmin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gharmaiadmin.entity.UserEntity

class UserAdapter(
    private val context: Context,
    private val userList: MutableList<UserEntity>
    ):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View):RecyclerView.ViewHolder(view){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}