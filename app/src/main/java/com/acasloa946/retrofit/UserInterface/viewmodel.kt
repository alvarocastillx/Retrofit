package com.acasloa946.retrofit.UserInterface

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.acasloa946.retrofit.Retrofit.RetrofitInstance
import com.acasloa946.retrofit.data.Car
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {
    private val apiService = RetrofitInstance.api
    var listaCoches : MutableState<List<Car>> = mutableStateOf(listOf<Car>())

    fun getCars() {
        viewModelScope.launch {
            val response = apiService.getCharacters()
            listaCoches.value = response
            for (i in listaCoches.value) {
                println(i.model)
            }
        }
    }

}

