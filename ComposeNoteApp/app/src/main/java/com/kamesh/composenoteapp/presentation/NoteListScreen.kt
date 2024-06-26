package com.kamesh.composenoteapp.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.kamesh.composenoteapp.data.local.room.Note


private const val TAG = "NoteList"

@Composable
fun NoteList(viewModel: NoteViewModel) {

    val context = LocalContext.current
    val list by  viewModel.noteList.observeAsState(initial = emptyList())


    Column(modifier = Modifier
        .fillMaxSize()) {

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.End
        ){

            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .size(40.dp)
                    .clickable {

                        viewModel.insertNote(Note(0, "Title", "description", imageUrl = ""))
                    }
            )
        }

        LazyColumn{




            items(list){ item ->

                var showSheet by remember { mutableStateOf(false) }


                if(showSheet){
                    ViewNote(item) {
                        showSheet = false
                    }
                }

                NoteItem(item) {
                    showSheet = true
                    Log.d(TAG, "NoteList: ${item.title}")
                }
            }
        }

    }
}



@Composable
fun NoteItem( noteItem : Note?, onView : () -> Unit){

    Card (
        modifier = Modifier
            .padding(10.dp)
            .clickable { onView() }
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .background(Color.Gray)
        ) {

            Text(text = "${noteItem?.id} - ${noteItem?.title}")
            Text(text = noteItem?.description ?: "")
        }
    }

}