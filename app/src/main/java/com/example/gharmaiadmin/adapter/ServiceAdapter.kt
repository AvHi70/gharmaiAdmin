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
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.entity.ServiceEntity

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
        println(services)
        holder.serviceName.text = services.serviceName
        holder.serviceDetail.text = services.serviceDetails
        holder.servicePrice.text = services.servicePrice

        holder.btnServiceDelete.setOnClickListener {
            Toast.makeText(context, "Data deleted", Toast.LENGTH_SHORT).show()
        }
    }



    override fun getItemCount(): Int {
        return serviceList.size
    }
}