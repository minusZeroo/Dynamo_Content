package com.example.dynamocontent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dynamocontent.ui.theme.DynamoContentTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

//We you need to display this list into a Jetpack composable
//The greeting list should accept a list of names
//using the advanced for loop, which should be easy to understand
//then we want to print a text
@Composable
fun MainScreen(){
    val greetingListState = remember { mutableStateListOf<String>("Paul", "Amanda") }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        GreetingList(greetingListState) { greetingListState.add("Jideani") }
    }
}


@Composable
fun GreetingList(nameList: List<String>, buttonClick: () -> Unit){
    for (name in nameList){
        Greeting(name = name)
    }
    Button(onClick = buttonClick) {
        Text(text = "Add new name")

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",
    style = MaterialTheme.typography.h4)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()

}