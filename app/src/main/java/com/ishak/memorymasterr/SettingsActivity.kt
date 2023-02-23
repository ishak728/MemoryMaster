package com.ishak.memorymasterr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        changePasswordTextView.setOnClickListener {

            val intent= Intent(this@SettingsActivity,ChangePasswordActivity::class.java)
            startActivity(intent)
            finish()

        }

        exitTextView.setOnClickListener{
            println("adssssssssssssssssss")
            val auth=Firebase.auth
            auth.signOut()
            val intent=Intent(this@SettingsActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}