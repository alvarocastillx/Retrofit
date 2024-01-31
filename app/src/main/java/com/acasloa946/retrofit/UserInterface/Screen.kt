package com.acasloa946.retrofit.UserInterface

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acasloa946.retrofit.data.Car

@Composable
fun Screen(viewModel: ViewModel) {
    val listaCoches = viewModel.listaCoches.value

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CarList(cars = listaCoches)
        Button(onClick = { viewModel.getCars() }) {
            Text(text = "Rescatar datos de API")
        }
    }
}

@Composable
fun CarList(cars: List<Car>) {
    LazyColumn {
        items(cars) {
            CarCard(it)
        }
    }
}

@Composable
fun CarCard(
    coche: Car
) {
    Card(
        Modifier
            .width(200.dp)
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
        )
    ) {
        Text(text = "Marca: ${coche.brand}", color = Color.White, fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Modelo: " + coche.model, color = Color.White, fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Caballos: " + coche.cv, color = Color.White, fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        Text(text = "Asientos: " + coche.seats, color = Color.White, fontSize = 15.sp, modifier = Modifier.padding(10.dp))
    }
}

