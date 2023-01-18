package com.example.tasklist.ui.APIs

import com.example.tasklist.ui.Placa
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

    interface FipeAPI {
        @GET("placa/consulta")
        fun getPlaca(@Query("placa") placa: String): Call<Placa>
    }
