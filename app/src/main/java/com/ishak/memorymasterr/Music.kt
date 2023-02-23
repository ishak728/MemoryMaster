package com.ishak.memorymasterr

import android.content.Context
import android.media.MediaPlayer
import kotlinx.coroutines.delay

class Music(val context:Context): Thread() {


    var prologue0: MediaPlayer=MediaPlayer.create(context,R.raw.prologue0)
    var victory1: MediaPlayer=MediaPlayer.create(context,R.raw.victory1)
    var shocked2: MediaPlayer=MediaPlayer.create(context,R.raw.shocked2)
    var congratulations3: MediaPlayer=MediaPlayer.create(context,R.raw.congratulations3)


    override fun run() {
        super.run()

    }
    fun startPrologue0(){
        prologue0.start()

    }

    fun pausePrologue0(){
        prologue0.pause()
    }

    fun startVictory1(){
        var victory1: MediaPlayer=MediaPlayer.create(context,R.raw.victory1)
        victory1.start()

    }
    fun pauseVictory(){
        victory1.pause()
    }

    fun startShocked2(){
        shocked2.start()

    }



    fun startCongratulations3(){
        pausePrologue0()
        congratulations3.start()
    }

    fun pauseAllVoice(){
        prologue0.stop()
        victory1.stop()
        shocked2.stop()
        congratulations3.stop()
    }



}