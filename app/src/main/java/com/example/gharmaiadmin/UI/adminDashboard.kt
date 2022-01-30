package com.example.gharmaiadmin.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.gharmaiadmin.Admin_Fragment.sevices_adding
import com.example.gharmaiadmin.Admin_Fragment.user_section
import com.example.gharmaiadmin.Admin_Fragment.worker_section
import com.example.gharmaiadmin.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class adminDashboard : AppCompatActivity() {
    private val User_Section = user_section()
    private var Worker_Section = worker_section()
    private val Service_Section = sevices_adding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)
        replacefragment(User_Section)

        val bottomNav = findViewById<BottomNavigationView>(R.id.botNav_admin)
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.user_section -> replacefragment(User_Section)
                R.id.worker_section -> replacefragment(Worker_Section)
                R.id.service -> replacefragment(Service_Section)
            }
            true
        }

    }

    private fun replacefragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.admin_frag_Container, fragment)
            transaction.commit()
        }

    }
}