package com.ishak.memorymasterr

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.ishak.memorymasterr.Model.AddFoto
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_level_six.*
import java.io.File
import java.io.Serializable
import java.lang.Exception
import kotlin.random.Random

class LevelSixActivity : AppCompatActivity() {


    private lateinit var prologue0:Music
    private lateinit var victory1:Music
    private lateinit var shocked2:Music
    private lateinit var congratulations3:Music
    var check=0
    var allCardsOpen=0






    var  gryffindorArrayList=ArrayList<AddFoto>()
    var slytherinArrayList =ArrayList<AddFoto>()
    var   hufflepuffArrayList=ArrayList<AddFoto>()
    var   ravenclawArrayList=ArrayList<AddFoto>()

    var isgryffindorDownLoad=false
    var isslytherinDownLoad=false
    var ishufflepuffDownLoad=false
    var isravenclawDownLoad=false
    var numberGamer=0

    var imageViewList = ArrayList<ImageView>()
    var textViewList = ArrayList<TextView>()

    var sayac=0
    var text1Name=""
    var score1=0.0
    var home1=0.0//ev katsayısı
    var homeName1=""//ev ismi
    var text2Name=""
    var score2=0.0
    var home2=0.0
    var homeName2=""

    var whichGamer=1//1 durumunda gamer1 devam edecek -1 durumunda gamer2 devam edecek
    var backupText1: TextView?=null
    var backupText2: TextView?=null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_six)




        switch1.setOnCheckedChangeListener({ _ , isChecked ->
            if (isChecked) {
                prologue0.pausePrologue0()
                victory1.pauseVictory()
                check=1
            }else {
                prologue0.startPrologue0()
            }

        })

        prologue0=Music(this@LevelSixActivity)
        victory1=Music(this@LevelSixActivity)
        shocked2=Music(this@LevelSixActivity)
        congratulations3=Music(this@LevelSixActivity)
        prologue0.start()
        victory1.start()
        shocked2.start()
        congratulations3.start()

        prologue0.startPrologue0()


        getDataGryffindorFromFirebase()
        getDataSlytherinFromFirebase()
        getDataRavenclawFromFirebase()
        getDataHufflepuffFromFirebase()



        imageViewList.add(img1)
        imageViewList.add(img2)
        imageViewList.add(img3)
        imageViewList.add(img4)
        imageViewList.add(img5)
        imageViewList.add(img6)
        imageViewList.add(img7)
        imageViewList.add(img8)
        imageViewList.add(img9)
        imageViewList.add(img10)
        imageViewList.add(img11)
        imageViewList.add(img12)
        imageViewList.add(img13)
        imageViewList.add(img14)
        imageViewList.add(img15)
        imageViewList.add(img16)
        imageViewList.add(img17)
        imageViewList.add(img18)
        imageViewList.add(img19)
        imageViewList.add(img20)
        imageViewList.add(img21)
        imageViewList.add(img22)
        imageViewList.add(img23)
        imageViewList.add(img24)
        imageViewList.add(img25)
        imageViewList.add(img26)
        imageViewList.add(img27)
        imageViewList.add(img28)
        imageViewList.add(img29)
        imageViewList.add(img30)
        imageViewList.add(img31)
        imageViewList.add(img32)
        imageViewList.add(img33)
        imageViewList.add(img34)
        imageViewList.add(img35)
        imageViewList.add(img36)



        textViewList.add(text1)
        textViewList.add(text2)
        textViewList.add(text3)
        textViewList.add(text4)
        textViewList.add(text5)
        textViewList.add(text6)
        textViewList.add(text7)
        textViewList.add(text8)
        textViewList.add(text9)
        textViewList.add(text10)
        textViewList.add(text11)
        textViewList.add(text12)
        textViewList.add(text13)
        textViewList.add(text14)
        textViewList.add(text15)
        textViewList.add(text16)
        textViewList.add(text17)
        textViewList.add(text18)
        textViewList.add(text19)
        textViewList.add(text20)
        textViewList.add(text21)
        textViewList.add(text22)
        textViewList.add(text23)
        textViewList.add(text24)
        textViewList.add(text25)
        textViewList.add(text26)
        textViewList.add(text27)
        textViewList.add(text28)
        textViewList.add(text29)
        textViewList.add(text30)
        textViewList.add(text31)
        textViewList.add(text32)
        textViewList.add(text33)
        textViewList.add(text34)
        textViewList.add(text35)
        textViewList.add(text36)









        //oyunun kaç kişilik olduğu belirleniyor
        val intent=intent
        numberGamer=intent.getIntExtra("numberGamer",1)

        if(numberGamer==1){
            startTime(45200)
            gamerTwoLinearLayout.visibility=View.GONE
            gamerOneTextView.setText("      Score:")
            println("numberGamer:"+numberGamer)

        }
        else{
            startTime(60200)
            println("numberGamer:"+numberGamer)
        }



    }




    fun startTime(time:Long){

        object : CountDownTimer(time,1000){
            override fun onTick(p0: Long) {

                timeTextView.setText(""+p0/1000)
            }

            override fun onFinish() {

                if(check==1) {
                    prologue0.pausePrologue0()
                    shocked2.startShocked2()
                }
                timeTextView.setText("Time finished")
                //alertdialogue oluşturacam.oun yeniden başlatılsın mı diye

                if (!(this@LevelSixActivity).isFinishing) {
                    val builder = AlertDialog.Builder(this@LevelSixActivity)
                    builder.setTitle("HELLO")
                    builder.setMessage("WOULD YOU LIKE TO PLAY THE GAME AGAIN?")
                    builder.setPositiveButton("YES") { dialog, which ->
                        Toast.makeText(applicationContext, "Starting", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@LevelSixActivity, LevelSixActivity::class.java)
                        intent.putExtra("numberGamer", numberGamer)
                        startActivity(intent)
                        finish()


                    }

                    builder.setNegativeButton("NO") { dialog, which ->
                        Toast.makeText(applicationContext, "Game over", Toast.LENGTH_SHORT).show()
                        val intent =
                            Intent(this@LevelSixActivity, SelectionLevelActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    builder.setCancelable(false)
                    builder.show()

                }
            }

        }.start()
    }







    fun getDataGryffindorFromFirebase(){
        val firestore= Firebase.firestore
        firestore.collection("g").get().addOnSuccessListener {result->
            for(document in result){
                val name= document.data.get("name").toString()
                val score=document.data.get("score").toString()
                val url=document.data.get("url").toString()
                val home=document.data.get("home").toString()
                val addFoto=AddFoto(name, score,url,home)
                gryffindorArrayList.add(addFoto)

                println("getgradsfaaaaa:size::::::"+gryffindorArrayList.size)

            }
        }.addOnCompleteListener {
            isgryffindorDownLoad=true
            downloadImage()
        }

    }
    fun getDataSlytherinFromFirebase(){
        val firestore= Firebase.firestore
        firestore.collection("s").get().addOnSuccessListener {result->
            for(document in result){
                val name= document.data.get("name").toString()
                val score=document.data.get("score").toString()
                val url=document.data.get("url").toString()
                val home=document.data.get("home").toString()
                val addFoto=AddFoto(name, score,url,home)
                slytherinArrayList.add(addFoto)
            }
        }.addOnCompleteListener {
            isslytherinDownLoad=true
            downloadImage()
        }
    }
    fun getDataHufflepuffFromFirebase(){
        val firestore= Firebase.firestore
        firestore.collection("h").get().addOnSuccessListener {result->
            for(document in result){
                val name= document.data.get("name").toString()
                val score=document.data.get("score").toString()
                val url=document.data.get("url").toString()
                val home=document.data.get("home").toString()
                val addFoto=AddFoto(name, score,url,home)
                hufflepuffArrayList.add(addFoto)
            }
        }.addOnCompleteListener {
            ishufflepuffDownLoad=true
            downloadImage()
        }
    }
    fun getDataRavenclawFromFirebase(){
        val firestore= Firebase.firestore
        firestore.collection("r").get().addOnSuccessListener {result->
            for(document in result){
                val name= document.data.get("name").toString()
                val score=document.data.get("score").toString()
                val url=document.data.get("url").toString()
                val home=document.data.get("home").toString()
                val addFoto=AddFoto(name, score,url,home)
                ravenclawArrayList.add(addFoto)
            }
        }.addOnCompleteListener {
            isravenclawDownLoad=true
            downloadImage()
        }
    }


    fun downloadImage(){

        //tüm verilerin arrayliste eklenip eklenmediğini kontrol ediyor
        if(isgryffindorDownLoad&&isravenclawDownLoad&&ishufflepuffDownLoad&&isslytherinDownLoad){

            val arrayList=ArrayList<AddFoto>()

            //tüm değerlerin birbirinden farklı olması için bir fonksiyon oluşturacam.çünkü bazen aynı değerler çıkabilir
            var number1 = Random.nextInt (11)
            var number2 = Random.nextInt (11)
            var number3 = Random.nextInt (11)
            var number4 = Random.nextInt (11)
            var number5 = Random.nextInt (11)
            var number6 = Random.nextInt (11)





            if(number1==number2){
                if(number1<10){
                    number1=number1+1
                }
                else{
                    number1=number1-1
                }
            }
            else{

                //arayüzde gösterilecek fotoğraflar arrayListe atanıyor
                arrayList.add(gryffindorArrayList.get(number1))
                arrayList.add(gryffindorArrayList.get(number2))
                arrayList.add(gryffindorArrayList.get(number3))
                arrayList.add(gryffindorArrayList.get(number4))
                arrayList.add(slytherinArrayList.get(number1))
                arrayList.add(slytherinArrayList.get(number2))
                arrayList.add(slytherinArrayList.get(number3))
                arrayList.add(slytherinArrayList.get(number4))
                arrayList.add(ravenclawArrayList.get(number1))
                arrayList.add(ravenclawArrayList.get(number2))
                arrayList.add(ravenclawArrayList.get(number3))
                arrayList.add(ravenclawArrayList.get(number4))
                arrayList.add(hufflepuffArrayList.get(number1))
                arrayList.add(hufflepuffArrayList.get(number2))
                arrayList.add(hufflepuffArrayList.get(number3))
                arrayList.add(hufflepuffArrayList.get(number4))
                arrayList.add(hufflepuffArrayList.get(number5))
                arrayList.add(hufflepuffArrayList.get(number6))


                println("********************************************************" +
                        "oyundaki fotoların özellikler")
                for(addFoto in arrayList){
                    println("name:"+addFoto.namee)
                    println("score:"+addFoto.score)
                    println("home:"+addFoto.home)

                }
                println("************************************************************")


                val yaz=File(applicationContext.filesDir,"deneme6.txt")

                for (addFoto in arrayList){
                    try {

                        yaz.printWriter().use { out ->
                            out.println(addFoto.namee)
                            out.println(addFoto.score)
                            out.println(addFoto.home)
                            println("girdi//////////////////////////////////////////////////////")


                        }


                    } catch (e: Exception) {
                        println("hattttttttttttttttttttttttttttaaaaaaa::::::::"+e.localizedMessage)
                    } finally {
                        println("---------------------")
                    }
                }

                val a=filesDir
                println("111111111111111111111111:::"+a)

                addImage(arrayList)
            }

        }

    }

    fun addImage(arrayList:ArrayList<AddFoto>){

        val yedek = Array<Int>(18){0}//size 18


        var i=0
        while(1==1){
            if(i==36)//36
                break

            //0 ve 7 dahil.8 dahil değil!!!
            val a= Random.nextInt (18)//18
            yedek[a]++
            if(yedek[a]>2)
                continue

            Picasso.get().load(arrayList.get(a).url).into(imageViewList.get(i))
            textViewList.get(i).setText(arrayList.get(a).namee)
            i++
        }

    }


    fun textViewClicked(view:View) {
        println("whiccccccccccchgamer:"+whichGamer)

        if (numberGamer == 1) {
            oneGamer(view)
        }
        else{

            sayac++

            if (sayac == 1) {
                backupText1 = view as TextView
                backupText1!!.visibility = View.INVISIBLE
                text1Name = backupText1!!.text.toString()

            } else if (sayac == 2) {
                backupText2 = view as TextView
                backupText2!!.visibility = View.INVISIBLE
                text2Name = backupText2!!.text.toString()

            }

            if (sayac == 2 && isEqual() == 2) {///eğer buton adları eşitse


                allCardsOpen++

                if(check==0) {
                    if (allCardsOpen == 18) {
                        congratulations3.startCongratulations3()
                        victory1.pauseVictory()
                    }

                    victory1.startVictory1()
                }

                whichHome()
                if (whichGamer == 1) {

                    //kartlar aynı olduğu için score1 veya score2 farketmez
                    val plusPoint=2*score1*home1
                    val newScore = gamerOneScore.text.toString().toDouble() + plusPoint
                    gamerOneScore.text = "" + newScore
                    println("gamer1:plus point:"+plusPoint)
                    println("score1:"+score1)
                    println("score2:"+score2)
                    println("home1:"+home1)
                    println("home2:"+home2)


                }
                else {
                    val plusPoint=2*score1*home1
                    val newScore = gamerTwoScore.text.toString().toDouble() + plusPoint
                    gamerTwoScore.text = "" + newScore
                    println("gamer2:plus point:"+plusPoint)
                    println("score1:"+score1)
                    println("score2:"+score2)
                    println("home1:"+home1)
                    println("home2:"+home2)
                }

            }

            //2 kart açık ama eşit değiller
            else if (sayac == 2 && isEqual() == 3) {
                whichHome()
                if(whichGamer==1){
                    if(homeName1==homeName2){
                        val negatifPoint=(score1+score2)/home1
                        val newScore = gamerOneScore.text.toString().toDouble() - negatifPoint
                        gamerOneScore.text = "" + newScore
                        println("gamer1:ev aynı:neagatif point:"+negatifPoint)
                        println("score1:"+score1)
                        println("score2:"+score2)
                        println("home1:"+home1)
                        println("home2:"+home2)
                    }
                    else{
                        val negatifPoint=(score1+score2)/2*home1*home2
                        val newScore = gamerOneScore.text.toString().toDouble() - negatifPoint
                        gamerOneScore.text = "" + newScore
                        println("gamer1:ev aynı değil:negatif point:"+negatifPoint)
                        println("score1:"+score1)
                        println("score2:"+score2)
                        println("home1:"+home1)
                        println("home2:"+home2)
                    }
                }//whichGamer2 için
                else{
                    if(homeName1==homeName2){
                        val negatifPoint=(score1+score2)/home1
                        val newScore = gamerTwoScore.text.toString().toDouble() - negatifPoint
                        gamerTwoScore.text = "" + newScore
                        println("gamer2:ev aynı :negatif point:"+negatifPoint)
                        println("score1:"+score1)
                        println("score2:"+score2)
                        println("home1:"+home1)
                        println("home2:"+home2)
                    }
                    else{
                        val negatifPoint=(score1+score2)/2*home1*home2
                        val newScore = gamerTwoScore.text.toString().toDouble() - negatifPoint
                        gamerTwoScore.text = "" + newScore
                        println("gamer2:ev aynı değil:negatif point:"+negatifPoint)
                        println("score1:"+score1)
                        println("score2:"+score2)
                        println("home1:"+home1)
                        println("home2:"+home2)
                    }
                }
                object : CountDownTimer(200, 1000) {
                    override fun onTick(p0: Long) {
                        println(p0)
                    }

                    override fun onFinish() {
                        println("yanlış kart")
                        backupText1!!.visibility = View.VISIBLE
                        backupText2!!.visibility = View.VISIBLE

                    }

                }.start()
                whichGamer *= -1
            }

            if (sayac == 2) {///iki tane butona basıldığını gösteriyor.
                enableTextView()
                sayac = 0;
            }

        }
    }


    fun oneGamer(view:View){

        sayac++

        if(sayac==1){
            backupText1=view as TextView
            backupText1!!.visibility=View.INVISIBLE
            text1Name= backupText1!!.text.toString()

        }
        else if(sayac==2){
            backupText2=view as TextView
            backupText2!!.visibility=View.INVISIBLE
            text2Name= backupText2!!.text.toString()

        }

        if(sayac==2&&isEqual()==2) {///eğer buton adları eşitse


            allCardsOpen++
            if(check==0) {
                if (allCardsOpen == 18) {
                    congratulations3.startCongratulations3()
                    victory1.pauseVictory()
                }

                victory1.startVictory1()
            }
            whichHome()


            var timeTextView=(timeTextView.text.toString().toDouble())

            //kartlar aynı olduğu için score1 veya score2 farketmez
            val plusPoint=2*score1*home1*(timeTextView/10)
            val newScore = gamerOneScore.text.toString().toDouble() + plusPoint
            gamerOneScore.text = "" + newScore
            println("dodruscore1:"+score1)
            println("score2:"+score2)
            println("home1:"+home1)
            println("home2:"+home2)
            println("timetextview"+timeTextView)

        }

        //2 kart açık ama eşit değiller
        else if(sayac==2&&isEqual()==3){
            whichHome()

            if(homeName1==homeName2){
                //geçen süredir

                var timeTextView=45-(timeTextView.text.toString().toDouble())

                val negatifPoint=(score1+score2)/home1*(timeTextView/10)
                val newScore = gamerOneScore.text.toString().toDouble() - negatifPoint
                gamerOneScore.text = "" + newScore
                println("yanlis ayniscore1:"+score1)
                println("score2:"+score2)
                println("home1:"+home1)
                println("home2:"+home2)

            }
            else{

                var timeTextView=45-(timeTextView.text.toString().toDouble())


                val negatifPoint=(score1+score2)/2*home1*home2*(timeTextView/10)
                val newScore = gamerOneScore.text.toString().toDouble() - negatifPoint
                gamerOneScore.text = "" + newScore
                println("yanlis ayni degil score1:"+score1)
                println("score2:"+score2)
                println("home1:"+home1)
                println("home2:"+home2)
                println("home naem"+homeName1)
                println("home naem"+homeName2)
                println("textname"+text1Name)
                println("textname"+text2Name)


            }

            object : CountDownTimer(200,1000){
                override fun onTick(p0: Long) {
                    println(p0)
                }

                override fun onFinish() {
                    println("yanlış kart")
                    backupText1!!.visibility=View.VISIBLE
                    backupText2!!.visibility=View.VISIBLE

                }

            }.start()
        }

        if(sayac==2){///iki tane butona basıldığını gösteriyor.
            enableTextView()
            sayac=0;
        }

    }


    fun isEqual():Int{

        if(text1Name.equals(text2Name)){
            return 2
        }
        else if(!text1Name.equals(text2Name)){
            return 3
        }
        return 0
    }

    fun disableTextView(){

        for (textView in textViewList){
            textView.setClickable(false)
        }
    }
    fun enableTextView(){
        for (textView in textViewList){
            textView.setClickable(true)
        }
    }

    fun whichHome(){

        println("++++++++++++++"+text1Name)
        println("++++++++++++++"+text2Name)
        val allArrayList=ArrayList<AddFoto>()
        allArrayList.addAll(gryffindorArrayList)
        allArrayList.addAll(slytherinArrayList)
        allArrayList.addAll(ravenclawArrayList)
        allArrayList.addAll(hufflepuffArrayList)



        for (addFoto in allArrayList){
            if(addFoto.namee==text1Name){
                score1=addFoto.score.toDouble()
                homeName1=addFoto.home
//glideroy lockhard
                if(homeName1=="Gryffindor") {
                    home1 = 2.0
                    println("/////////////////"+1)
                }
                else if(homeName1=="Slytherin") {
                    home1 = 2.0
                    println("/////////////////"+2)
                }
                else if(homeName1=="Hufflepuff") {
                    home1 = 1.0
                    println("/////////////////"+3)
                }
                else if(homeName1=="Ravenclaw") {
                    home1 = 1.0
                    println("/////////////////"+4)
                }
            }
            if(addFoto.namee==text2Name){
                score2=addFoto.score.toDouble()
                homeName2=addFoto.home

                if(homeName2=="Gryffindor") {
                    home2 = 2.0
                    println("/////////////////"+5)
                }
                else if(homeName2=="Slytherin") {
                    home2 = 2.0
                    println("/////////////////"+6)
                }
                else if(homeName2=="Hufflepuff") {
                    home2 = 1.0
                    println("/////////////////"+7)
                }
                else if(homeName2=="Ravenclaw") {
                    home2 = 1.0
                    println("/////////////////"+8)
                }

            }



        }


    }
    override fun onPause() {
        super.onPause()

        prologue0.pausePrologue0()
        victory1.pauseVictory()

    }

}