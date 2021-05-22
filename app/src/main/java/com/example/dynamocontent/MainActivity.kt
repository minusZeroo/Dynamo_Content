package com.example.dynamocontent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.dynamocontent.ui.theme.DynamoContentTheme

//Using a list structure to store a list of names
val namesList: List<String> = listOf("Paul", "James", "Arinze", "Thandi", "Georgia")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingList(names = namesList)
        }
    }
}

//We you need to display this list into a Jetpack composable
//The greeting list should accept a list of names
//using the advanced for loop, which should be easy to understand
//then we want to print a text
@Composable
fun GreetingList(names: List<String>){
    Column() {
        for (name in names){
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GreetingList(names = namesList)

}