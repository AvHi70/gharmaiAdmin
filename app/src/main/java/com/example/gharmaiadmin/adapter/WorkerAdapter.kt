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
import com.example.gharmaiadmin.repository.UserRepository
import com.example.gharmaiadmin.repository.WorkerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
        var workerID = worker._id
        holder.workerName.text = worker.workerName
        holder.workerEmail.text = worker.workerEmail
        holder.workerAddress.text = worker.workerAddress
        holder.workerContact.text = worker.workerContactNo
        holder.workerGender.text = worker.workerGender

        holder.deleteButton.setOnClickListener {
            val builder = android.app.AlertDialog.Builder(context)
            builder.setTitle("Are You Sure want to Delete?")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("Yes"){_,_->
                if (workerID != null){
                    workerDelete(workerID)
                    workerList.remove(worker)
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
    fun workerDelete(serviceID: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = WorkerRepository()
                val response = repository.deleteWorker(serviceID)
                if (response.success==true) {
//                    sevices_adding.serviceList?.remove(ServiceEntity())
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            context,
                            "Worker deleted", Toast.LENGTH_SHORT
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
        return workerList.size
    }
}