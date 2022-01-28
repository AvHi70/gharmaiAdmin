package com.example.gharmaiadmin.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.gharmaiadmin.R

class adminSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_splashscreen)

        Handler().postDelayed({
            startActivity(Intent(this@adminSplash, adminDashboard::class.java))
        },4000)
    }
}