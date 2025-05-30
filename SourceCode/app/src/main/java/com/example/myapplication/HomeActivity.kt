package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Icon
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class HomeActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        val onBackClick = { finish() }
                        TopAppBar(
                            title = {
                                Text(
                                    text = "Detail",
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
                    val context = LocalContext.current
                    ComponentsListScreen(
                        paddingValues = innerPadding,
                        onBackClick = { finish() },
                        onComponentClick = { component ->
                            val intent = Intent(context, component.activityClass)
                            startActivity(intent)
                        }
                    )
                }
            }
        }
    }
}

sealed class ListItem {
    data class Header(val title: String) : ListItem()
    data class ComponentItem(val name: String, val description: String, val activityClass: Class<out ComponentActivity>) : ListItem()
}

@Composable
fun ComponentsListScreen(
    onComponentClick: (ListItem.ComponentItem) -> Unit,
    onBackClick: () -> Unit,
    paddingValues: PaddingValues
) {
    val listItems = listOf(
        ListItem.Header("Display"),
        ListItem.ComponentItem("Text", "Displays text", TextDetailActivity::class.java),
        ListItem.ComponentItem("Image", "Displays an image", ImageDetailActivity::class.java),
        ListItem.ComponentItem("Button", "Button with different colors", ButtonDetailActivity::class.java),

        ListItem.Header("Input"),
        ListItem.ComponentItem("TextField", "Input field for text", TextFieldDetailActivity::class.java),
        ListItem.ComponentItem("PasswordField", "Input field for passwords", PasswordFieldDetailActivity::class.java),

        ListItem.Header("Layout"),
        ListItem.ComponentItem("Column", "Arranges elements vertically", ColumnDetailActivity::class.java),
        ListItem.ComponentItem("Row", "Arranges elements horizontally", RowDetailActivity::class.java),
        ListItem.ComponentItem("Box", "Arranges elements in a box", BoxDetailActivity::class.java),

        ListItem.Header("Detail"),
        ListItem.ComponentItem("Detail", "Arranges elements vertically", Detail::class.java),
        ListItem.ComponentItem("Detail", "Arranges elements horizontally", Detail::class.java),
        ListItem.ComponentItem("Detail", "Arranges elements vertically", Detail::class.java),
        ListItem.ComponentItem("Detail", "Arranges elements horizontally", Detail::class.java),
        ListItem.ComponentItem("Detail", "Arranges elements vertically", Detail::class.java),
        ListItem.ComponentItem("Detail", "Arranges elements horizontally", Detail::class.java),
        ListItem.ComponentItem("Detail", "Arranges elements vertically", Detail::class.java),
        ListItem.ComponentItem("Detail", "Arranges elements horizontally", Detail::class.java),
        ListItem.ComponentItem("Detail", "Arranges elements in a box", Detail::class.java)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues)
            .padding(horizontal = 16.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(listItems) { item ->
                when (item) {
                    is ListItem.Header -> {
                        ComponentListHeader(title = item.title)
                    }
                    is ListItem.ComponentItem -> {
                        ComponentListItem(component = item) {
                            onComponentClick(item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ComponentListHeader(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 8.dp)
    )
}

@Composable
fun ComponentListItem(component: ListItem.ComponentItem, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .background(Color(0x4D03A9F4), shape = MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = component.name,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        Text(
            text = component.description,
            fontSize = 16.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComponentsListScreenPreview() {
    MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ComponentsListScreen(onComponentClick = {}, onBackClick = {}, paddingValues = innerPadding)
        }
    }
}