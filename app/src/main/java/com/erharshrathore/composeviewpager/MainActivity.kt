package com.erharshrathore.composeviewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erharshrathore.composeviewpager.ui.theme.ComposeViewpagerExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeViewpagerExampleTheme {
                Greeting(Modifier)
            }
        }
    }
}

@Preview("greeting", showBackground = true)
@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    to: String = "World"
) {
    Box(
        modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Hello $to", style = MaterialTheme.typography.h2)
    }
}

