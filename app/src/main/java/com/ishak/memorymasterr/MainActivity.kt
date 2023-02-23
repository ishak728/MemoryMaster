package com.ishak.memorymasterr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object :CountDownTimer(3100,1000){
            override fun onTick(p0: Long) {
                println(p0)
            }

            override fun onFinish() {
                println("finish")


                val auth= Firebase.auth
                val currentUser=auth.currentUser

                if(currentUser!=null){

                    val intent=Intent(this@MainActivity,NumberGamerActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    val intent=Intent(this@MainActivity,LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }


            }

        }.start()



    }
}