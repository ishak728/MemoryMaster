package com.ishak.memorymasterr

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_number_gamer.*
import kotlinx.android.synthetic.main.activity_selection_level.*
import kotlinx.android.synthetic.main.activity_selection_level.startButton

class SelectionLevelActivity : AppCompatActivity() {
    private var whichLevel:Int=0
    private var numberGamer=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_level)
        val intent=intent
       numberGamer=intent.getIntExtra("numberGamer",0)
        println("numbergamerrrr:"+numberGamer)
        levelTwo.setOnClickListener{
            whichLevel=2
            it.setBackgroundColor(Color.GREEN)
            levelFour.setBackgroundColor(Color.BLACK)
            levelSix.setBackgroundColor(Color.BLACK)
        }
        levelFour.setOnClickListener{
            whichLevel=4
            it.setBackgroundColor(Color.GREEN)
            levelTwo.setBackgroundColor(Color.BLACK)
            levelSix.setBackgroundColor(Color.BLACK)
        }
        levelSix.setOnClickListener{
            whichLevel=6
            it.setBackgroundColor(Color.GREEN)
            levelFour.setBackgroundColor(Color.BLACK)
            levelTwo.setBackgroundColor(Color.BLACK)
        }


        startButton.setOnClickListener{view->

            if(whichLevel!=0){

                if(whichLevel==2){
                    val intent= Intent(this@SelectionLevelActivity,LevelTwoActivity::class.java)
                    intent.putExtra("numberGamer",numberGamer)
                    println("numbergamer:"+numberGamer)
                    startActivity(intent)
                    whichLevel=0

                }
                else if(whichLevel==4){
                    val intent= Intent(this@SelectionLevelActivity,LevelFourActivity::class.java)
                    intent.putExtra("numberGamer",numberGamer)
                    println("numbergamer:"+numberGamer)
                    startActivity(intent)
                    whichLevel=0

                }
                else if(whichLevel==6){
                    val intent= Intent(this@SelectionLevelActivity,LevelSixActivity::class.java)
                    intent.putExtra("numberGamer",numberGamer)
                    println("numbergamer:"+numberGamer)
                    startActivity(intent)
                    whichLevel=0

                }

            }
            else{
                Toast.makeText(applicationContext,"make sure that you choose a level",
                    Toast.LENGTH_LONG).show()
                //hexdecimale göre renk ayarlıyor
                startButton.setBackgroundColor(Color.parseColor("#69F0AE"))
            }

            levelFour.setBackgroundColor(Color.BLACK)
            levelTwo.setBackgroundColor(Color.BLACK)
            levelSix.setBackgroundColor(Color.BLACK)


        }

    }

  /*  fun go_to_game(intent:Intent){

        intent.putExtra("numberGamer",numberGamer)
        println("numbergamer:"+numberGamer)
        startActivity(intent)
    }*/



}