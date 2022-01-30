package com.example.gharmaiadmin.Admin_Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.UI.addService
import com.google.android.material.bottomnavigation.BottomNavigationView


class sevices_adding : Fragment() {


    private lateinit var AddService: Button





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sevices_adding, container, false)

        AddService = view.findViewById(R.id.btnaddService)

        AddService.setOnClickListener {
            startActivity(Intent(activity,addService::class.java))
        }

        return view
    }



}




