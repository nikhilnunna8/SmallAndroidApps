package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme
import androidx.compose.foundation.layout.Column

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonApp(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}
@Composable
fun LemonApp(modifier: Modifier = Modifier, imageResourceId: Int, ) {
    val imageResource = imageResourceId
    Column() {
        Image(
            painter = painterResource(imageResource),
            contentDescription = stringResource(R.string.lemonTree)
        )
        Button(onClick = { /*TEST*/ })
        {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun LemonAppPreview() {
    LemonApp(modifier = Modifier, imageResourceId = R.drawable.lemon_tree)
}