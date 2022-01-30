package com.example.gharmaiadmin.Admin_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.adapter.UserAdapter
import com.example.gharmaiadmin.entity.UserEntity
import com.example.gharmaiadmin.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class user_section : Fragment() {

    private lateinit var recyclerView: RecyclerView

    companion object{
        private var userList: MutableList<UserEntity>? = ArrayList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user_section, container, false)

        recyclerView = view.findViewById(R.id.userSection)


        userView()
        return view
    }

    private fun userView() {

        Toast.makeText(context, "user working ", Toast.LENGTH_SHORT).show()
        userList = ArrayList()
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val userRepository = UserRepository()
                val userResponse = userRepository.getAllUsers()

                if(userResponse.success== true){
                    val userLists = userResponse.data

                    if (userLists != null) {
                        userLists.forEach { item ->
                            userLists.add(item)
                        }
                        withContext(Dispatchers.Main){
                            val userAdapter = context?.let { UserAdapter(it, userLists) }
                            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                            recyclerView.adapter = userAdapter
                        }
                    }

                }

            }catch (ex: Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}