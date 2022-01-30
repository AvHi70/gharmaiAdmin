package com.example.gharmaiadmin.Admin_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.adapter.WorkerAdapter
import com.example.gharmaiadmin.entity.WorkerEntity
import com.example.gharmaiadmin.repository.WorkerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class worker_section : Fragment() {

    private lateinit var recyclerView: RecyclerView

    companion object{
        private var workerList: MutableList<WorkerEntity>? = ArrayList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_worker_section, container, false)

        recyclerView = view.findViewById(R.id.workerSection)
        viewWorker()
        return view


    }

    private fun viewWorker() {

        workerList = ArrayList()
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val workerRepository = WorkerRepository()
                val workerResponse = workerRepository.getAllWorker()

                if(workerResponse.success== true){
                    val workerLists = workerResponse.data
                    if (workerLists != null) {
                        workerLists.forEach { item ->
                            workerLists.add(item)

                        }
                        withContext(Dispatchers.Main){
                            val workerAdapter = context?.let { WorkerAdapter(it, workerLists) }
                            Toast.makeText(context, "$workerLists", Toast.LENGTH_SHORT).show()

                            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                            recyclerView.adapter = workerAdapter
                        }
                    }else{
                        Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show()
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