package com.example.gharmaiadmin.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.gharmaiadmin.R
import com.example.gharmaiadmin.entity.AdminEntity
import com.example.gharmaiadmin.entity.ServiceEntity
import com.example.gharmaiadmin.repository.AdminRepository
import com.example.gharmaiadmin.repository.ServiceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class admin_register : AppCompatActivity() {

    private lateinit var adminName: EditText
    private lateinit var adminEmail: EditText
    private lateinit var adminPassword: EditText
    private lateinit var adminRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_register)

        adminName = findViewById(R.id.adminRegisterUsername)
        adminEmail = findViewById(R.id.adminRegisterEmail)
        adminPassword = findViewById(R.id.adminRegisterPassword)
        adminRegister = findViewById(R.id.registerButton)

        adminRegister.setOnClickListener {
            adminRegister()
            Toast.makeText(this, "Registered as Admin", Toast.LENGTH_SHORT).show()
        }
    }
    private fun adminRegister(){
        val adminName = adminName.text.toString()
        val adminEmail = adminEmail.text.toString()
        val adminPassword = adminPassword.text.toString()


        if (isValid()){
            val admin = AdminEntity(
                adminName = adminName, adminEmail = adminEmail, adminPassword = adminPassword
            )
            CoroutineScope(Dispatchers.IO).launch {
                //StudentDB(this@UserRegister).getUserDAO().registerUser(user)
                try{
                    val adminRepository = AdminRepository()
                    val adminResponse = adminRepository.registerAdmin(admin)

                    if (adminResponse.success ==true){
                        withContext(Dispatchers.Main){
                            Toast.makeText(this@admin_register, "Service added", Toast.LENGTH_SHORT).show()
                        }
                        startActivity(Intent(this@admin_register, admin_login::class.java))
                    }
                }catch (ex:Exception){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@admin_register, ex.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        else{
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
        }
    }
    private fun isValid():Boolean{
        when{
            adminName.text.isEmpty() -> {
                adminName.error="Service Name cannot be Empty"
                adminName.requestFocus()
                return false
            }
            adminEmail.text.isEmpty() -> {
                adminEmail.error="Service Price cannot be Empty"
                adminEmail.requestFocus()
                return false
            }
            adminPassword.text.isEmpty() -> {
                adminPassword.error="Please tell about service"
                adminPassword.requestFocus()
                return false
            }
        }
        return true
    }
}