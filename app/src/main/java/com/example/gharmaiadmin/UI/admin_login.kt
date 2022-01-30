package com.example.gharmaiadmin.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.api.ServiceBuilder
import com.example.gharmaiadmin.repository.AdminRepository
import com.example.gharmaiadmin.repository.UserRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class admin_login : AppCompatActivity() {

    private lateinit var createAccount: TextView
    private lateinit var adminLoginEmail: EditText
    private lateinit var adminLoginPassword: EditText
    private lateinit var adminLogin: Button
    private lateinit var linearLayout: ConstraintLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)


        createAccount = findViewById(R.id.createAccount)
        adminLoginEmail = findViewById(R.id.adminUsername)
        adminLoginPassword = findViewById(R.id.adminPassword)
        adminLogin = findViewById(R.id.loginButton)
        linearLayout = findViewById(R.id.linearLayout)


        createAccount.setOnClickListener {
            startActivity(Intent(this,admin_register::class.java))
        }
        adminLogin.setOnClickListener {
            loginAdmin()
            Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show()
        }

    }

    private fun loginAdmin() {

        val email = adminLoginEmail.text.toString()
        val password = adminLoginPassword.text.toString()

        if (email == "admin" && password == "admin") {
//            startActivity(Intent(this@admin_login, admin_splashscreen::class.java))
        } else {

            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val repository = AdminRepository()
                    val response = repository.loginAdmin(email, password)
                    if (response.success == true) {
                        // Save token

                        ServiceBuilder.token = "Bearer ${response.token}"
                        ServiceBuilder.userId = response.userId
                        //Save username and password in shared preferences
                        // saveUsernamePassword()

                        startActivity(
                            Intent(
                                this@admin_login, adminDashboard::class.java
                            )
                        )
//                    Toast.makeText(this@LoginActivity, "Login Success" , Toast.LENGTH_SHORT).show()
                        finish()
                    } else {
                        withContext(Dispatchers.Main) {
                            val snack =
                                Snackbar.make(
                                    linearLayout,
                                    "Invalid credentials",
                                    Snackbar.LENGTH_LONG
                                )
                            snack.setAction("OK", View.OnClickListener {
                                snack.dismiss()
                            })
                            snack.show()
                        }
                    }
                } catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Log.d("grshgi", ex.toString())

                        Toast.makeText(
                            this@admin_login,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}