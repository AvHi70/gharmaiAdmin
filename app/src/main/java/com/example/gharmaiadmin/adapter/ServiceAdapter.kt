package com.example.gharmaiadmin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gharmaiadmin.Fragments.sevices_adding
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.api.ServiceBuilder
import com.example.gharmaiadmin.entity.ServiceEntity
import com.example.gharmaiadmin.repository.ServiceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ServiceAdapter(
    private val context: Context,
    private val serviceList: MutableList<ServiceEntity>
): RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    class ServiceViewHolder(view: View): RecyclerView.ViewHolder(view){

    val serviceName: TextView = view.findViewById(R.id.tvServiceName)
    val serviceDetail: TextView = view.findViewById(R.id.tvServiceDetail)
    val servicePrice: TextView = view.findViewById(R.id.tvServicePrice)
    val btnServiceDelete: Button = view.findViewById(R.id.btnDeleteService)
    val serviceImage: ImageView = view.findViewById(R.id.serviceImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.service_recycle, parent, false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {


        val services = serviceList[position]
        var serviceID = services._id
        var serviceCategory = services.serviceCategory
        println(services)
        holder.serviceName.text = services.serviceName
        holder.serviceDetail.text = services.serviceDetails
        holder.servicePrice.text = services.servicePrice

//        Glide.with(context)
//            .load(ServiceBuilder.BASE_URL + services.serviceImage)
//            .into(holder.serviceImage)

        holder.btnServiceDelete.setOnClickListener {
            val builder = android.app.AlertDialog.Builder(context)
            builder.setTitle("Are You Sure want to Delete?")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes"){_,_->
                if (serviceID != null){
                    serviceDelete(serviceID)
                    serviceList.remove(services)
                    notifyDataSetChanged()
                }
//                    Toast.makeText(context, "Music Successfully Deleted", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("No"){_,_->
                Toast.makeText(context, "Action Cancelled", Toast.LENGTH_SHORT).show()
            }
            val alertDialog: android.app.AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }

    fun serviceDelete(serviceID: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = ServiceRepository()
                val response = repository.deleteService(serviceID)
                if (response.success==true) {
//                    sevices_adding.serviceList?.remove(ServiceEntity())
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            context,
                            "Service deleted", Toast.LENGTH_SHORT
                        ).show()

                    }

                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            context,
                            "Delete failed", Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        context,
                        "Error", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return serviceList.size
    }
}