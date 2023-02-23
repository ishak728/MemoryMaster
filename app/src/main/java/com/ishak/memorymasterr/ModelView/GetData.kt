package com.ishak.memorymasterr.ModelView

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ishak.memorymasterr.Model.AddFoto

class GetData() : ViewModel() {

   lateinit var gryffindorArrayList:ArrayList<AddFoto>
   lateinit var slytherinArrayList: ArrayList<AddFoto>
    lateinit   var hufflepuffArrayList:ArrayList<AddFoto>
    lateinit  var ravenclawArrayList:ArrayList<AddFoto>


/*
    fun getDataGryffindorFromFirebase(){
        val firestore=Firebase.firestore
        firestore.collection("g").get().addOnSuccessListener {result->
            for(document in result){
               val name= document.data.get("name").toString()
                val score=document.data.get("score").toString()
                val url=document.data.get("url").toString()
                val addFoto=AddFoto(name, score,url)
                gryffindorArrayList.add(addFoto)
            }
        }
    }
    fun getDataSlytherinFromFirebase(){
        val firestore=Firebase.firestore
        firestore.collection("s").get().addOnSuccessListener {result->
            for(document in result){
                val name= document.data.get("name").toString()
                val score=document.data.get("score").toString()
                val url=document.data.get("url").toString()
                val addFoto=AddFoto(name, score,url)
                slytherinArrayList.add(addFoto)
            }
        }
    }
    fun getDataHufflepuffFromFirebase(){
        val firestore=Firebase.firestore
        firestore.collection("h").get().addOnSuccessListener {result->
            for(document in result){
                val name= document.data.get("name").toString()
                val score=document.data.get("score").toString()
                val url=document.data.get("url").toString()
                val addFoto=AddFoto(name, score,url)
                hufflepuffArrayList.add(addFoto)
            }
        }
    }
    fun getDataRavenclawFromFirebase(){
        val firestore=Firebase.firestore
        firestore.collection("r").get().addOnSuccessListener {result->
            for(document in result){
                val name= document.data.get("name").toString()
                val score=document.data.get("score").toString()
                val url=document.data.get("url").toString()
                val addFoto=AddFoto(name, score,url)
                ravenclawArrayList.add(addFoto)
            }
        }
    }*/
}