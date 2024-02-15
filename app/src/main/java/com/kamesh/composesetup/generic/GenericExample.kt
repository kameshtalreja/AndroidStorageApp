package com.kamesh.composesetup.generic

import android.util.Log

private const val TAG = "GenericExample"
class ArrayUtil<T>(private val array: Array<T>) {
    fun findElement( element : T, foundElement : (index : Int, element : T?) -> Unit){
        for (i in array.indices){
            if (array[i] == element){
                foundElement(i,array[i])
                return
            }
        }
        foundElement(-1,null)
        return
    }
}

fun<T> findElementGeneric(array: Array<T>, element : T, foundElement : (index : Int, element : T?) -> Unit){
    for (i in array.indices){
        if (array[i] == element){
            foundElement(i,array[i])
            return
        }
    }
    foundElement(-1,null)
    return
}

fun main() {

    val arrayUtil = ArrayUtil<Int>(arrayOf(1,2,3,4,5))
    val arrayUtil2 = ArrayUtil<String>(arrayOf("1","2","3","4","5"))


    arrayUtil.findElement(3){ index,element ->
        println("$TAG main: $index - $element")
    }
    arrayUtil2.findElement("5"){ index,element ->
        println("$TAG main: $index - $element")
    }
    findElementGeneric<Char>(arrayOf('A','B','C','D','E'),'D'){ index, element ->
        println("$TAG main: $index - $element")
    }
}