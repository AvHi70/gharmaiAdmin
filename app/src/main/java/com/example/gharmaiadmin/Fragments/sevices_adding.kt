package com.example.gharmaiadmin.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gharmaiadmin.InsideUI.Electrician
import com.example.gharmaiadmin.InsideUI.SalonForMan
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.UI.ShowServiceActivity
import com.example.gharmaiadmin.UI.addService
import com.example.gharmaiadmin.adapter.ServiceAdapter
import com.example.gharmaiadmin.adapter.UserAdapter
import com.example.gharmaiadmin.entity.ServiceEntity
import com.example.gharmaiadmin.entity.UserEntity
import com.example.gharmaiadmin.repository.ServiceRepository
import com.example.gharmaiadmin.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class sevices_adding : Fragment() {


    private lateinit var serviceAdd: Button
    private lateinit var salonWomenFrag: CardView
    private lateinit var electrician: CardView
    private lateinit var menTherapy: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.all_service_admin, container, false)

        serviceAdd = view.findViewById(R.id.buttonAddService)
        salonWomenFrag = view.findViewById(R.id.salonWomen)
        electrician = view.findViewById(R.id.electricians)
        menTherapy = view.findViewById(R.id.menTherapy1212)

        serviceAdd.setOnClickListener {
            startActivity(Intent(context, addService::class.java))
        }
        salonWomenFrag.setOnClickListener {
            startActivity(Intent(context, ShowServiceActivity::class.java))
        }
        electrician.setOnClickListener {
            startActivity(Intent(activity, Electrician::class.java))
        }
        menTherapy.setOnClickListener {
            startActivity(Intent(context, SalonForMan::class.java))
        }

        return view
    }
}




