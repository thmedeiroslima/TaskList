package com.example.tasklist.ui


import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(value = "/placa/consulta")
    fun getPost() :Call<MutableList<PostModel>>
}