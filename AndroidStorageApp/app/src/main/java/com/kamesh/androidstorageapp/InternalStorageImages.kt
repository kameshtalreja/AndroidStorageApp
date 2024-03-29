package com.kamesh.androidstorageapp

import android.graphics.Bitmap

data class InternalStorageImages (
    val imageName : String,
    val imageBitmap : Bitmap
)


fun main(){

    var str = "hello world monkey is#ok"


    var p = str
        .plus("")
        .alphaNumericOnly().split(" ").map { it->
        it.lowercase()
        it.replaceFirstChar { firstChar ->
            firstChar.uppercaseChar()
        }
    }.joinToString("").replaceFirstChar { firstCh -> firstCh.lowercase() }
        .reversed()
//        .map { it -> it.replaceFirstChar { Char::uppercaseChar } }
    print(p)
}

fun String.alphaNumericOnly() : String {
    val regex = Regex("[^A-Za-z0-9]")
    return regex.replace(this," ")
}