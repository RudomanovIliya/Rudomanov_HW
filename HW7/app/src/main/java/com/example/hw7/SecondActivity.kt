package com.example.hw7

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw7.ui.theme.HW7Theme

class SecondActivity : ComponentActivity() {
    companion object {
        private const val KEY_HELLO = "key_hello"

        fun createStartIntent(context: Context, value: String): Intent {
            return Intent(context, SecondActivity::class.java).apply {
                putExtra(KEY_HELLO, value)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondScreen(
                modifier = Modifier.fillMaxSize(),
                intent?.getStringExtra(KEY_HELLO)
            )
        }
    }
}

@Composable
fun SecondScreen(modifier: Modifier = Modifier, text: String?) {
    val context = LocalContext.current

    Column(
        modifier = modifier.padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .width(260.dp)
                .height(112.dp),
            painter = painterResource(id = R.drawable.rectangle),
            contentDescription = ""
        )
        Image(
            modifier = Modifier
                .width(260.dp)
                .height(242.dp)
                .padding(top = 50.dp),
            painter = painterResource(id = R.drawable.image),
            contentDescription = ""
        )

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.gray)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(top = 16.dp)
                .width(300.dp)
                .height(50.dp),
            onClick = {
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(
                color = Color.Black,
                fontSize = 20.sp,
                text = stringResource(R.string.notify)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview1() {
    HW7Theme {
        SecondScreen(modifier = Modifier.fillMaxSize(), text = "Test")
    }
}