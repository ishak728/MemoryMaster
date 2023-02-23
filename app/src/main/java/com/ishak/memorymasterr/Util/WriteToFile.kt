package com.ishak.memorymasterr.Util

import com.ishak.memorymasterr.Model.AddFoto
import java.io.File
import java.io.FileWriter
import java.lang.Exception

class WriteToFile() {



    fun writeToFile(arrayList:ArrayList<AddFoto>){


        var yaz = FileWriter("deneme4.txt",true)
        var i=0
        while (i!=8) {
            try {
                yaz.write("kral\n")
                yaz.write("kraasfdl\n")
            }
            catch (e:Exception){

            }
            i++
        }
        yaz.close()


    }
}