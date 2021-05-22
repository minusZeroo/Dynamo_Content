package com.example.dynamocontent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
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

    val newNameStateContent = remember { mutableStateOf(" ") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        GreetingList(greetingListState,
            { greetingListState.add(newNameStateContent.value) },
            newNameStateContent.value,
            { newName -> newNameStateContent.value = newName}) //new name the user entered
    }
}


@Composable
fun GreetingList(nameList: List<String>, buttonClick: () -> Unit, textFieldValue: String, textFieldUpdate: (newName: String) -> Unit){
    for (name in nameList){
        Greeting(name = name)
    }


    TextField(value = textFieldValue, onValueChange = textFieldUpdate)


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