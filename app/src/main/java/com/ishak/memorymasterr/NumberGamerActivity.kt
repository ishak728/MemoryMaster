package com.ishak.memorymasterr

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_number_gamer.*

class NumberGamerActivity : AppCompatActivity() {
    private var numbergamer:Int=0
    private var whichLevel:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_gamer)



        singlePlayerButton.setOnClickListener{
            numbergamer=1
            //eğer seçildiyse
            singlePlayerButton.setBackgroundColor(Color.GREEN)
            doublePlayerButton.setBackgroundColor(Color.BLACK)
        }
        doublePlayerButton.setOnClickListener{
            numbergamer=2
            singlePlayerButton.setBackgroundColor(Color.BLACK)
            doublePlayerButton.setBackgroundColor(Color.GREEN)
        }

        startButton.setOnClickListener {
            val intent= Intent(this@NumberGamerActivity,SelectionLevelActivity::class.java)
            intent.putExtra("numberGamer",numbergamer)
            startActivity(intent)
            singlePlayerButton.setBackgroundColor(Color.BLACK)
            doublePlayerButton.setBackgroundColor(Color.BLACK)
        }







    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater=getMenuInflater()
        menuInflater.inflate(R.menu.settings,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId==R.id.settings){
            val intent= Intent(this@NumberGamerActivity,SettingsActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("ondestroy")
    }
}