package com.example.gharmaiadmin.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.entity.UserEntity

class UserAdapter(
    private val context: Context,
    private val userList: MutableList<UserEntity>
    ):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View):RecyclerView.ViewHolder(view){

        val username: TextView = view.findViewById(R.id.profileName)
        val userPicture: ImageView = view.findViewById(R.id.profileImage)
        val userEmail: TextView = view.findViewById(R.id.profileEmail)
        val userAddress: TextView = view.findViewById(R.id.profileAddress)
        val userContact: TextView = view.findViewById(R.id.profileContact)
        val userGender: TextView = view.findViewById(R.id.profileGender)
        val deleteButton: Button = view.findViewById(R.id.buttonDelete)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_worker_recycle_design, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {

        val users = userList[position]
        println(users)
        holder.username.text = users.username
        holder.userEmail.text = users.emailUser
        holder.userAddress.text = users.addressUser
        holder.userContact.text = users.phoneUser
        holder.userGender.text = users.genderUser

        holder.deleteButton.setOnClickListener {
            Toast.makeText(context, "Data deleted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}