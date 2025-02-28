package com.example.layout01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layout01.ui.theme.Layout01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Layout01Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black // Fundo preto igual à imagem
                ) {
                    FormLayout()
                }
            }
        }
    }
}

@Composable
fun FormLayout() {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var selectedStatus by remember { mutableStateOf("") }
    var selectedPriority by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Black),
        horizontalAlignment = Alignment.Start
    ) {
        // Logo e nome do App
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Logo",
                tint = Color.White,
                modifier = Modifier.size(40.dp)
            )
            Text(
                text = "UILabs",
                color = Color.White,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de título
        Text("Title", color = Color.White, fontSize = 16.sp)
        BasicTextField(
            value = title,
            onValueChange = { title = it },
            textStyle = LocalTextStyle.current.copy(color = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = 0.3f))
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Status
        Text("Status", color = Color.White, fontSize = 16.sp)
        Row {
            RadioButton(selected = selectedStatus == "Done", onClick = { selectedStatus = "Done" })
            Text("Done", color = Color.White, modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(
                selected = selectedStatus == "Not Done",
                onClick = { selectedStatus = "Not Done" })
            Text("Not Done", color = Color.White, modifier = Modifier.padding(start = 4.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Prioridade
        Text("Priority", color = Color.White, fontSize = 16.sp)
        Row {
            RadioButton(selected = selectedPriority == "Low", onClick = { selectedPriority = "Low" })
            Text("Low", color = Color.White, modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = selectedPriority == "Medium", onClick = { selectedPriority = "Medium" })
            Text("Medium", color = Color.White, modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = selectedPriority == "High", onClick = { selectedPriority = "High" })
            Text("High", color = Color.White, modifier = Modifier.padding(start = 4.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Botões de data e hora
        Row {
            Button(onClick = { /* Escolher data */ }) {
                Text("Choose Date")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { /* Escolher hora */ }) {
                Text("Choose Time")
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun PreviewFormLayout() {
    Layout01Theme {
        FormLayout()
    }
}