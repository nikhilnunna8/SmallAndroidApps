package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import java.io.StringReader
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonApp(
                        modifier = Modifier
                            .fillMaxSize(),
                        imageResourceId = R.drawable.lemon_tree,
                        stringResourceId = R.string.lemon
                    )
                }
            }
        }
    }
}
@Composable
fun LemonApp(modifier: Modifier = Modifier, imageResourceId: Int, stringResourceId: Int) {
    var imageRes by remember { mutableStateOf(1) }
    var random by remember {
        mutableStateOf((3..4).random())
    }
    val imageResource = when(imageRes) {
        1 -> R.drawable.lemon_tree
        in(2..random) -> R.drawable.lemon_squeeze
        random+1 -> R.drawable.lemon_drink
        random+2 -> R.drawable.lemon_restart
        random+3 -> R.drawable.lemon_tree
        else -> {1}
    }
    val stringResource = when(imageRes) {
        1 -> R.string.tapLemonSelect
        in(2..random) -> R.string.tapLemonSqueeze
        random+1 -> R.string.tapLemonDrink
        random+2 -> R.string.tapEmptyGlass
        random+3 -> R.string.tapLemonSelect
        else -> {1}
    }
    if (imageRes == random+3){
        imageRes = 1
        random = (3..4).random()
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {imageRes = imageRes + 1},
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(153, 23, 23))
        )
        {
            Image(
                painter = painterResource(imageResource),
                contentDescription = null
            )
        }
        Text(
            text = stringResource(stringResource)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonAppPreview() {
    LemonApp(
        modifier = Modifier.fillMaxSize(),
        imageResourceId = R.drawable.lemon_tree,
        stringResourceId = R.string.lemonTree
    )
}