package com.example.hw7

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw7.SecondActivity.Companion.createStartIntent
import com.example.hw7.ui.theme.HW7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = modifier.padding(top = 344.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello World!",
            fontSize = 20.sp,
        )
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(top = 40.dp)
                .width(300.dp)
                .height(50.dp),
            onClick = {
                val intent = Intent(createStartIntent(context, "Hello World!"))
                context.startActivity(intent)
            }
        ) {
            Text(
                color = Color.Black,
                fontSize = 20.sp,
                text = stringResource(R.string.activity_2)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HW7Theme {
        Greeting(modifier = Modifier.fillMaxSize())
    }
}