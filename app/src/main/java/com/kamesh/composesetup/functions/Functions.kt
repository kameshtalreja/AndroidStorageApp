package com.kamesh.composesetup.functions


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