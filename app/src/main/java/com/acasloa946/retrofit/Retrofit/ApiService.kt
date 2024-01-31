package com.acasloa946.retrofit.Retrofit

import com.acasloa946.retrofit.data.Car
import retrofit2.http.GET

interface ApiService {
    @GET("all/")
    suspend fun getCharacters():List<Car>
}