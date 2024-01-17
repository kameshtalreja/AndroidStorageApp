package com.kamesh.composesetup.patterns

import android.util.Log


private const val TAG = "AdapterDesignPattern"

interface Pen {
    fun write(task: String)
}


class Assignment() {

    var pen : Pen? = null

    fun doAssignment(task : String){

        pen?.write(task)
    }
}

class Marker() {

    fun using(text: String){
        Log.d(TAG, "using: $text")
    }
}

class PenAdapter() : Pen {

    var market = Marker()

    override fun write(task: String) {
        market.using(task)
    }

}

fun runAdapterPattern(){

    var pen = PenAdapter()
    var assignment = Assignment()
    assignment.pen = pen
    assignment.doAssignment("this is my assignment")
}

