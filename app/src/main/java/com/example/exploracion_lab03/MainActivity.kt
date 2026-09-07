package com.example.exploracion_lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    // Cambia esta función por VistaEstructuraBase() o VistaListasYTarjetas() para probarlas
                    VistaEstructuraBase()
                }
            }
        }
    }
}

// ---------------- VISTAS COMPONIBLES ----------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VistaEstructuraBase() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Aplicación") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(selected = true, onClick = {}, icon = { Icon(Icons.Filled.Home, "Inicio") }, label = { Text("Inicio") })
                NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Filled.Person, "Perfil") }, label = { Text("Perfil") })
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, "Agregar")
            }
        }
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            Text(text = "Contenido dentro del Scaffold", modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEstructuraBase() { VistaEstructuraBase() }

@Composable
fun VistaFormulario() {
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = "", onValueChange = {},
            label = { Text("Nombre Completo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = {})
            Text("Aceptar términos")
            Spacer(modifier = Modifier.width(16.dp))
            Switch(checked = true, onCheckedChange = {})
            Text("Notificaciones")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = true, onClick = {})
            Text("Opción A")
            RadioButton(selected = false, onClick = {})
            Text("Opción B")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("Nivel de volumen")
        Slider(value = 0.5f, onValueChange = {})

        Spacer(modifier = Modifier.height(16.dp))
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFormulario() { VistaFormulario() }

@Composable
fun VistaListasYTarjetas() {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            LazyRow {
                items(3) { index ->
                    AssistChip(
                        onClick = {},
                        label = { Text("Filtro $index") },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        }

        items(2) {
            Card(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
                Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                        contentDescription = "Imagen",
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text("Título de la Tarjeta")
                        Row {
                            Icon(Icons.Filled.Star, contentDescription = "Estrella", modifier = Modifier.size(16.dp))
                            Text("Favorito")
                        }
                    }
                }
            }
        }
        item {
            Button(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                Text("Mostrar Dialog / Snackbar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListasYTarjetas() { VistaListasYTarjetas() }