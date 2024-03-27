package com.kamesh.composenoteapp.data.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "noteTable")
data class Note(

    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var title : String,
    var description : String,
    var isChecked : Boolean = false,
    var imageUrl : String?
)
