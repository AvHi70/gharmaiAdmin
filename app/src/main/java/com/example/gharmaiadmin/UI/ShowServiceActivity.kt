package com.example.gharmaiadmin.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.adapter.ServiceAdapter
import com.example.gharmaiadmin.api.ServiceBuilder
import com.example.gharmaiadmin.entity.ServiceEntity
import com.example.gharmaiadmin.repository.ServiceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShowServiceActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    companion object{
        var serviceList: ArrayList<ServiceEntity> = ArrayList<ServiceEntity>()
//        var serviceList: MutableList<ServiceEntity>? = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_service)

        recyclerView = findViewById(R.id.serviceRecyclerView)
        serviceView()

    }
        private fun serviceView() {
        serviceList = ArrayList()

        CoroutineScope(Dispatchers.IO).launch {
            try {

                val serviceRepository = ServiceRepository()
                val serviceResponse = serviceRepository.getAllServiceAPI()

                if(serviceResponse.success== true){
                    val serviceLists = serviceResponse.data
//                    ServiceBuilder.serviceCategory = serviceResponse.serviceCategory

                    println(serviceLists)

//                    withContext(Dispatchers.Main){
//                        Toast.makeText(this@ShowServiceActivity, " and $serviceCategory", Toast.LENGTH_SHORT).show()
//                    }

                    if (serviceLists != null ) {
                        serviceLists.forEach { item ->
                            serviceList.add(item)
                        }
                        withContext(Dispatchers.Main){
                            val serviceAdapter = ShowServiceActivity?.let { ServiceAdapter(this@ShowServiceActivity, serviceLists) }
                            recyclerView.layoutManager = LinearLayoutManager(this@ShowServiceActivity, LinearLayoutManager.VERTICAL, false)
                            recyclerView.adapter = serviceAdapter
                        }
                    }
                }

            }catch (ex: Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@ShowServiceActivity, ex.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}