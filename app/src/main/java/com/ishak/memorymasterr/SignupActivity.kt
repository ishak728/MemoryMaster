package com.ishak.memorymasterr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth
    private lateinit var fireStore:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        auth=Firebase.auth
        fireStore=Firebase.firestore

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        toLogin.setOnClickListener {
            val intent= Intent(this@SignupActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        nextButton.setOnClickListener {
            val userName=userTextView.text.toString()
            val ePosta=ePostaTextView.text.toString()
            val password=passwordTextView.text.toString()

            auth.createUserWithEmailAndPassword(ePosta,password).addOnSuccessListener {
               // val uid= auth.currentUser?.uid
                //firestore'a ekleme yapılması gerekir

                val userInfosMap= hashMapOf<String,Any>()
                userInfosMap.put("userName",userName)
                userInfosMap.put("ePosta",ePosta)
                userInfosMap.put("password",password)
                if(auth.uid!=null)
                    userInfosMap.put("uid",auth.uid!!)

                fireStore.collection("userInfo").add(userInfosMap).addOnSuccessListener{
                    Toast.makeText(applicationContext,"Succesfull\n+${it}",Toast.LENGTH_LONG).show()
                    val intent= Intent(this@SignupActivity,NumberGamerActivity::class.java)
                    startActivity(intent)
                    finish()

                }.addOnFailureListener {
                    println("failure:51"+it)
                }


            }.addOnFailureListener {
                Toast.makeText(applicationContext,"Failure\n+${it}",Toast.LENGTH_LONG).show()
            }

        }
    }
}