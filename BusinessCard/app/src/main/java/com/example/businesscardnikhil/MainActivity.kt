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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
                        name = "Nikhil Nunna",
                        job = "High School Student",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardContactInfo(number: String, email: String, insta: String, modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
        ) {
            Icon(
                Icons.Default.Call,
                contentDescription = null,
                tint = Color(40, 67, 135),
                modifier = Modifier
                    .padding(start = 85.dp, top = 15.dp)

            )
            Text(
                text = number,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(start = 2.dp, top = 15.dp)
            )
        }
        Row(
        ) {
            Icon(
                Icons.Default.Email,
                contentDescription = null,
                tint = Color(40, 67, 135),
                modifier = Modifier
                    .padding(start = 85.dp, top = 15.dp)

            )
            Text(
                text = email,
                fontSize = 19.sp,
                textAlign = TextAlign.Center,

                modifier = Modifier
                    .padding(top = 15.dp, end=10.dp)
            )
        }
        Row(
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = null,
                tint = Color(40, 67, 135),
                modifier = Modifier
                    .padding(start = 85.dp, top = 15.dp)

            )
            Text(
                text = insta,
                fontSize = 19.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 15.dp, end=10.dp)
            )
        }
    }
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
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(450.dp)
                    .padding(top = 50.dp, bottom = 1.dp)
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
                    .padding(bottom = 80.dp)
                    .fillMaxWidth()
            )
            BusinessCardContactInfo(
                "224-293-2342",
                "nikhil.nunna9@gmail.com",
                "@niktheeighth",
                Modifier
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