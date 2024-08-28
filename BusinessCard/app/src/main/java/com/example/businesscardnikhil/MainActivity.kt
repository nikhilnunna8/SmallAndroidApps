package com.example.businesscardnikhil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardnikhil.ui.theme.BusinessCardNikhilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardNikhilTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCardText(
                        name = "Android",
                        job = "king",
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
@Composable
fun BusinessCardText(name: String, job: String, modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()

    ) {

        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
        ) {
            val image = painterResource(R.drawable._000004659)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .width(500.dp)
                    .padding(top = 50.dp, bottom = 100.dp)
            )
            Icon(
                Icons.Default.Call,
                contentDescription = null
            )
            Text(
                text = name,
                fontSize = 33.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Text(
                text = job,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardNikhilTheme {
        BusinessCardText("Nikhil Nunna", "High School Student")
    }
}