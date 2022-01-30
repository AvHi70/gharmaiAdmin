package com.example.gharmaiadmin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gharmaiadmin.entity.ServiceEntity

class ServiceAdapter(
    private val context: Context,
    private val serviceList: MutableList<ServiceEntity>
): RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    class ServiceViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    override fun getItemCount(): Int {
        return serviceList.size
    }
}