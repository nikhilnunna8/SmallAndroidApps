package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IntegerRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpace(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
//sdbshdbshbd
@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    var position by remember { mutableStateOf(0) }
    var imageResource = when(position){
        0 -> R.drawable.london
        1 -> R.drawable.paris
        2 -> R.drawable.amsterdam
        3 -> R.drawable.chicago
        4 -> R.drawable.newyork
        5 -> R.drawable.beijing
        else -> R.drawable.capetown
    }
    var titleResource = when(position){
        0 -> R.string.londonTitle
        1 -> R.string.parisTitle
        2 -> R.string.amsterdamTitle
        3 -> R.string.chicagoTitle
        4 -> R.string.newyorkTitle
        5 -> R.string.beijingTitle
        else -> R.string.capeTownTitle
    }
    var descResource = when(position){
        0 -> R.string.londonDescription
        1 -> R.string.parisDescription
        2 -> R.string.amsterdamDescription
        3 -> R.string.chicagoDescription
        4 -> R.string.newyorkDescription
        5 -> R.string.beijingDescription
        else -> R.string.capeTownDescription
    }
    Column(modifier = modifier) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = null
        )
        Row(){
            Column() {
                Text(text = stringResource(titleResource))
                Text(text = stringResource(descResource))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row() {
            ArtSpaceButtons(onChange1 = {position++}, onChange2 = {position--})
        }
    }
}

@Composable
fun ArtSpaceButtons(
    onChange1: () -> Unit,
    onChange2: () -> Unit
){
    Button(onClick = onChange2) {
        Text(text = stringResource(R.string.backward))
    }
    Button(onClick = onChange1) {
        Text(text = stringResource(R.string.forward))
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace(
            modifier = Modifier
                .fillMaxSize()
        )
    }
}