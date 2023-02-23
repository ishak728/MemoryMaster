package com.ishak.memorymasterr.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ishak.memorymasterr.Model.AddFoto
import com.ishak.memorymasterr.R
import kotlinx.android.synthetic.main.recycler_view.view.*

class CharectersAdapter(val arrayList:ArrayList<AddFoto>):RecyclerView.Adapter<CharectersAdapter.CharectesViewHolder>() {

    class CharectesViewHolder(val view:View): RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharectesViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_view,parent,false)
        return CharectesViewHolder(view)


    }

    override fun onBindViewHolder(holder: CharectesViewHolder, position: Int) {
        holder.view.home.text=arrayList.get(position).home
        holder.view.name.text=arrayList.get(position).namee
        holder.view.score.text=arrayList.get(position).score
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}