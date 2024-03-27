package com.kamesh.composenoteapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kamesh.composenoteapp.data.local.room.Note


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewNote(selectItem: Note?, onDismiss: () -> Unit) {

    val modelBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modelBottomSheetState,
        dragHandle = {BottomSheetDefaults.DragHandle()}) {

        selectItem.let {
            ViewNote(it)

        }

    }
}

@Composable
fun ViewNote(selectItem: Note?) {

    Column (modifier = Modifier
        .padding(20.dp)
        .fillMaxWidth()
        .height(300.dp)){

        Text(
            text = "Title",
            fontSize = 17.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            text = "${selectItem?.title} ${selectItem?.id}" ,
            fontSize = 21.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 6.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.padding(vertical = 10.dp))

    }
}