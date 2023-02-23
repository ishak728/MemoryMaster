package com.ishak.memorymasterr

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ishak.memorymasterr.Adapter.CharectersAdapter
import com.ishak.memorymasterr.Model.AddFoto
import kotlinx.android.synthetic.main.activity_charecters.*


class Charecters : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charecters)



    }

    fun operateAdapter(list:ArrayList<AddFoto>){
        var arrayList=ArrayList<TextView>()

        arrayList.add(t1)
        arrayList.add(t2)
        arrayList.add(t3)
        arrayList.add(t4)
        arrayList.add(t5)
        arrayList.add(t6)
        arrayList.add(t7)
        arrayList.add(t8)
        arrayList.add(t9)
        arrayList.add(t10)
        arrayList.add(t11)
        arrayList.add(t12)
        arrayList.add(t13)
        arrayList.add(t14)
        arrayList.add(t15)
        arrayList.add(t16)

        var i=0
        for (addFoto in list){
            arrayList.get(i).text=addFoto.namee
            i++
        }
    }



}