package com.example.gharmaiadmin.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gharmaiadmin.entity.WorkerEntity

class WorkerAdapter(
    private val context: Context,
    private val workerList: MutableList<WorkerEntity>
):RecyclerView.Adapter<WorkerAdapter.WorkerViewHolder>() {

    class WorkerViewHolder(view: View): RecyclerView.ViewHolder(view){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerAdapter.WorkerViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: WorkerAdapter.WorkerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}