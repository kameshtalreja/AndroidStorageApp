package com.kamesh.composesetup.functions

import java.util.concurrent.Flow.Subscription




/** example og inline function */
fun normalFunc(){
    print("Hello")
    callInline()
}

inline fun callInline() {
    print(" Word")
}


/** example of higher order function */
fun addMethod(value1 : Int,value2 : Int ) : Int{
    return value1 + value2
}

fun printResult(  v1 : Int, v2 : Int, add : (Int,Int) -> Int){
    add(v1,v2)
}

fun calling(){
    printResult(4,5, ::addMethod)  //{ a: Int, b: Int -> a + b }
}


/** Extension Function */
fun String.addExclamation() : String {
    return "$this!"

}

var str = "Kamesh".addExclamation()


/** Infix Function */

/* extension infix*/
infix fun Int.addCustom(value : Int) = this + value

/* class member infix */
class Math(var amount : Int) {
    infix fun minusCustom(value : Int) = amount - value
}

fun check(){
    var c = 5 addCustom 10 // extension

    val obj = Math(10)
    var res = obj minusCustom 5
}




var strText = "hello world"

fun split(){
    strText.filter {
        !it.equals('o')
    }.map {
        "$it <-"
    }.onEach {
        println("Split Function |  -> $it")
    }
}

fun main() {
    split()
}
