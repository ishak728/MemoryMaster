package com.ishak.memorymasterr

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firestore=Firebase.firestore
        val auth=Firebase.auth
        val currentUser=auth.currentUser

        if(currentUser!=null){
            println("login curent usera girdimiiiiiiiiiiiiii")
            val intent=Intent(this@LoginActivity,NumberGamerActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            println("currrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrent:::"+currentUser)
        }

        toSignUp.setOnClickListener {
            val intent=Intent(this@LoginActivity,SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
        nextButton.setOnClickListener {

            val userName=userTextView.text.toString()

            val num=userName.indexOf("@")
            if(num!=-1){
                signInWithEposta()
            }
            else{

                signIn()
            }




        }
    }


    fun signIn(){
        println("6")
        var available:Boolean=false
        val userName=userTextView.text.toString()
        val password=passwordTextView.text.toString()

        firestore.collection("userInfo")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    println("doccccccccccc")
                    //println("${document.id} => ${document.data.get("userName")}")
                    if(document.data.get("userName")==userName&&document.data.get("password")==password){
                        println(document.data.get("userName"))
                        println(document.data.get("password"))
                        println("************************67")
                        available=true
                        break
                    }
                }
                if(available){
                    println("72 login")
                    val intent=Intent(this@LoginActivity,NumberGamerActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(applicationContext,"failure",Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener { exception ->
                println("Failure."+exception)
            }
    }

    fun signInWithEposta(){
        val auth=Firebase.auth
        val eposta=userTextView.text.toString()
        val password=passwordTextView.text.toString()

        auth.signInWithEmailAndPassword(eposta,password).addOnSuccessListener {
            val intent=Intent(this@LoginActivity,NumberGamerActivity::class.java)
            startActivity(intent)
            finish()

        }.addOnFailureListener {
            Toast.makeText(applicationContext,"${it.localizedMessage}",Toast.LENGTH_LONG).show()
        }


    }
}