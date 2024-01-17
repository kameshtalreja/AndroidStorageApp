package com.kamesh.composesetup.scope

import android.util.Log


private const val TAG = "ScopeFunctions"

/**
 * keyword ---- :-- Context Object--:--Return Value
 * -------------------------------------------------
 * Let          :   it              :  lambda result
 * run          :   this            : lambda result
 * with         :   this            : lambda result
 * apply        :   this            : context Object
 * also         :   it              : content object
 * */

fun main2() {
        
//    mainLet()

//    mainRun()

//    mainWith()

//    mainApply()

//    mainAlso()
}


/** also using for initial configuration
 * it return context object and it present with it */
fun mainAlso(){

    var square = Square(width = 10, height = 10).also {
        it.addText("it text")
        it.addColor("it orange")
    }
    println(square)
}

/** apply return the context object as return type
 **/
fun mainApply(){

    var square = Square(width = 10, height = 10).apply {
        addColor("apply color")
        addText("apply text")
    }

}

/** with is helping to use args of object without mention the name and
 * return type will be fro lambda, and
 * if you pass this keyword it pass the reference of current to to new object
 * below it condition */
fun mainWith(){

    var square = Square(width = 10, height = 10)
    var a = with(square){
        addText("with text")
        addColor("with color")
        this
    }
    square.text = "cement"
    println(square)
    println(a)
}

/** it simply return lambda result to square object and it help to avoid the name of object with args*/
fun mainRun(){

    val square = Square(width = 10, height = 10).run {
        addColor("RED")
        addText("this is text")
        this
    }

    println(square)
}

lateinit var squareLet: Square
fun mainLet(){


    val square = Square(width = 10, height = 10).let { sq ->
        sq.addText("hello")
        sq.addColor("red")
        sq
    }

    /** Checking null safety and assigning the value directly */
    square.let { squareLet = it }

    //check null safety


    println("$TAG main: $square")

}



class Square(
    val width : Int,
    val height : Int,
    var color : String? = null,
    var text : String? = null
) {

    fun addColor(color : String){
        this.color = color
        println("$TAG  setColor: $color")
    }

    fun addText(text : String){
        this.text = text
        println("$TAG setText: $text")
    }

    override fun toString(): String {
        return "Square(width=$width, height=$height, color=$color, text=$text)"
    }
}

