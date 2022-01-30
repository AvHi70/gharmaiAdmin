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
import com.example.gharmaiadmin.entity.WorkerEntity

class WorkerAdapter(
    private val context: Context,
    private val workerList: MutableList<WorkerEntity>
):RecyclerView.Adapter<WorkerAdapter.WorkerViewHolder>() {

    class WorkerViewHolder(view: View): RecyclerView.ViewHolder(view){

        val workerName: TextView = view.findViewById(R.id.profileName)
        val workerPicture: ImageView = view.findViewById(R.id.profileImage)
        val workerEmail: TextView = view.findViewById(R.id.profileEmail)
        val workerAddress: TextView = view.findViewById(R.id.profileAddress)
        val workerContact: TextView = view.findViewById(R.id.profileContact)
        val workerGender: TextView = view.findViewById(R.id.profileGender)
        val deleteButton: Button = view.findViewById(R.id.buttonDelete)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkerAdapter.WorkerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_worker_recycle_design, parent, false)
        return WorkerViewHolder(view)
    }

    override fun onBindViewHolder(holder: WorkerViewHolder, position: Int) {

        val worker = workerList[position]
        println(worker)
        holder.workerName.text = worker.workerName
        holder.workerEmail.text = worker.workerEmail
        holder.workerAddress.text = worker.workerAddress
        holder.workerContact.text = worker.workerContactNo
        holder.workerGender.text = worker.workerGender

        holder.deleteButton.setOnClickListener {
            Toast.makeText(context, "Data deleted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return workerList.size
    }
}