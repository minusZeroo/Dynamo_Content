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
import androidx.compose.runtime.livedata.observeAsState
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
fun MainScreen(viewModel: MainViewModel = MainViewModel()) {

    val newNameStateContent = viewModel.textFieldState.observeAsState("")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        GreetingMessage(
            newNameStateContent.value
        ) { newName -> viewModel.onTextChanged(newName) } //new name the user entered
    }
}


@Composable
fun GreetingMessage(
    textFieldValue: String,
    textFieldUpdate: (newName: String) -> Unit
) {
    TextField(value = textFieldValue, onValueChange = textFieldUpdate)

    Button(onClick = { }) {
        Text(textFieldValue)

    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.h4
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()

}