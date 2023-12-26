package com.kamesh.composesetup.presentation.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

//@Preview(showBackground = true)

@Composable
fun HomeScreen(
//    @Inject stringDefault : String,

    viewModel : HomeViewModel = hiltViewModel()
) {

//    val viewModel : HomeViewModel = hiltViewModel()
//    @Inject
//    @Named("hello1")
//    lateinit var hello: String

    val articleStateList = viewModel.articlesList.collectAsState()
//      lateinit var  stringDefault : String
    Column(modifier = Modifier.fillMaxSize()){
//        Text(text = hello)
        LazyColumn (modifier = Modifier.padding(16.dp)){

            items ( articleStateList.value.size){ item ->

                Card (
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    modifier = Modifier.fillMaxWidth().height(80.dp).padding(bottom = 10.dp)
                ){
                    Row (){
                        Column (
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(8.dp)
                        ){
                            Text(
                                text = "Name" ,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                fontSize = 18.sp
                            )
                            Text(
                                text = "10 km",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                fontSize = 14.sp
                            )
                        }
                    }
                }


            }
        }
    }
}