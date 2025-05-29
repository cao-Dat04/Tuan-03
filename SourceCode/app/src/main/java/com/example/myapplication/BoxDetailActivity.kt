package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class BoxDetailActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                BoxDetailScreenContent(onBackClick = { finish() })
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxDetailScreenContent(onBackClick: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Box Detail",
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color(0xFF2196F3)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF2196F3)
                        )
                    }
                },
                actions = {
                    Spacer(modifier = Modifier.width(48.dp))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp)
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color(0xFFE0E0E0))
                    .border(1.dp, Color.Gray)
            ) {
                Text(
                    text = "Top Start",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Top Center",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(8.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Top End",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Center Start",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(8.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Center",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(8.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Center End",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(8.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Bottom Start",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(8.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Bottom Center",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(8.dp),
                    fontSize = 14.sp
                )
                Text(
                    text = "Bottom End",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}
