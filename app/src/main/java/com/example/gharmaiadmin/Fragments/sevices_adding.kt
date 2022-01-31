package com.example.gharmaiadmin.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gharmaiadmin.R
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


    private lateinit var addService: Button
    private lateinit var recyclerView: RecyclerView

    companion object{
        private var serviceList: ArrayList<ServiceEntity> = ArrayList<ServiceEntity>()
//        private var serviceList: MutableList<ServiceEntity>? = ArrayList()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sevices_adding, container, false)

        addService = view.findViewById(R.id.btnaddService)
        recyclerView = view.findViewById(R.id.serviceRecyclerView)

        addService.setOnClickListener {
            startActivity(Intent(this@sevices_adding.context, addService::class.java))

        }

//        val serviceAdapter = context?.let { ServiceAdapter(it, serviceList) }
//        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        recyclerView.adapter = serviceAdapter

        serviceView()
        return view
    }

    private fun serviceView() {
        serviceList = ArrayList()

        CoroutineScope(Dispatchers.IO).launch {
            try {

                val serviceRepository = ServiceRepository()
                val serviceResponse = serviceRepository.getAllServiceAPI()

                if(serviceResponse.success== true){
                    val serviceLists = serviceResponse.data
                    println(serviceLists)
                    if (serviceLists != null) {
                        serviceLists.forEach { item ->
                            serviceList.add(item)
                        }
                        withContext(Dispatchers.Main){
                            val serviceAdapter = context?.let { ServiceAdapter(it, serviceLists) }
                            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                            recyclerView.adapter = serviceAdapter
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




