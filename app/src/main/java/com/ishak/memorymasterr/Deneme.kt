package com.ishak.memorymasterr

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_deneme.*
import kotlinx.android.synthetic.main.activity_level_six.*
import java.util.*

class Deneme : AppCompatActivity() {

    private lateinit var fireStore:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deneme)






    }


    fun imageButtonClicked(view:View){
        getPermission(view)
    }


    fun getPermission(view:View){

        if(ContextCompat.checkSelfPermission(applicationContext,android.Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.INTERNET).toString()
                )){
                Snackbar.make(view,"permissions needed", Snackbar.LENGTH_INDEFINITE).setAction("give permissions"){
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.INTERNET),1)

                }
            }
            else{
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.INTERNET),1)
            }
        }
        else{
            //galeriye git ve resmi al
            val intent_gallery= Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent_gallery,2)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode==1){
            if (grantResults.size>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext,"Allowed for image", Toast.LENGTH_LONG).show()
                //galeriye gidilecek.seçim yapıp yapmadığımıza bağlı olarak onActivityResult'a bilgi gönderir
                val intent_gallery= Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent_gallery,2)
            }
        }
        else{
            Toast.makeText(applicationContext,"Not Allowed for image", Toast.LENGTH_LONG).show()
        }

        if(requestCode==1){
            if (grantResults.size>0&&grantResults[1]== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(applicationContext,"Allowed for internet", Toast.LENGTH_LONG).show()

            }
        }
        else{
            Toast.makeText(applicationContext,"Not Allowed for internet", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val firestore=Firebase.firestore
        val name=nameEditText.text.toString()
        val score=scoreEditText.text.toString()
        val home=homeEditText2.text.toString()


        val uuid= UUID.randomUUID()
        var imageName="$uuid.jpg"

        val storage=Firebase.storage
        super.onActivityResult(requestCode, resultCode, data)
        println("resultcode"+resultCode)
        println("re")
        if(requestCode==2&&resultCode== RESULT_OK){
            if (data != null) {
                val image_uri=data.data
                val reference=storage.reference
                val imageref=reference.child("images").child(imageName)



                println("image_uri::"+image_uri)
                if (image_uri != null) {

                    imageref.putFile(image_uri).addOnSuccessListener {
                        println(1)
                        val uploadPictureReference=storage.reference.child("images").child(imageName)
                        println(2)
                        uploadPictureReference.downloadUrl.addOnSuccessListener {
                            println(3)
                            val downloadUrl=it.toString()
                            println("124 downloadurl"+downloadUrl)

                            val postMap= hashMapOf<String,Any>()
                            postMap.put("name",name)
                            postMap.put("score",score)
                            postMap.put("url",downloadUrl)

                            firestore.collection(home).add(postMap).addOnSuccessListener {
                                println("başarılı :"+name)
                            }.addOnFailureListener {
                                println("başarısız :"+name)
                            }

                        }.addOnFailureListener {
                            println("140 hata:"+it)
                        }

                    }.addOnFailureListener{
                        println("hata:"+it)
                    }

                    image.setImageURI(image_uri)
                }
                else{
                    println("107:nullllldır")
                }
            }
        }
        else{
            println("request ya da result kodda hata var")
        }
    }
}