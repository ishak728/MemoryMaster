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
import kotlinx.android.synthetic.main.activity_change_password.*
import kotlinx.android.synthetic.main.activity_change_password.nextButton
import kotlinx.android.synthetic.main.activity_login.*

class ChangePasswordActivity : AppCompatActivity() {
    //authentication'daki password güncelliyor
    val user = Firebase.auth.currentUser
    private lateinit var firestore:FirebaseFirestore
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        nextButton.setOnClickListener {
            //burada şifre güncellenmesi yapılacak
            firestore=Firebase.firestore
            auth=Firebase.auth
            var available:Boolean=false
            val ePosta=ePostaTextView.text.toString()
            val oldPassword=oldPasswordTextView.text.toString()
            val newPassword=newPasswordTextView.text.toString()

            firestore.collection("userInfo")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        //println("${document.id} => ${document.data.get("userName")}")
                        if(document.data.get("ePosta")==ePosta&&document.data.get("password")==oldPassword){
                            //firestore'deki password güncelleniyor'
                            firestore.collection("userInfo").document(document.id).update("password",newPassword)





                            user!!.updatePassword(newPassword)
                                .addOnCompleteListener { task ->


                                    if (task.isSuccessful) {
                                        Toast.makeText(applicationContext,"111Succesfull", Toast.LENGTH_LONG).show()
                                    }
                                    else{
                                        Toast.makeText(applicationContext,"111failure", Toast.LENGTH_LONG).show()
                                    }
                                }
                            available=true
                            break
                        }
                    }
                    if(available){
                        Toast.makeText(applicationContext,"4Succesfull", Toast.LENGTH_LONG).show()
                        val intent= Intent(this@ChangePasswordActivity,SettingsActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(applicationContext,"5failure", Toast.LENGTH_LONG).show()
                    }
                }
                .addOnFailureListener { exception ->
                    println("Failure."+exception)
                }
        }
    }
}