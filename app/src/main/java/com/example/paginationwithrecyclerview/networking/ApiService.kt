package com.example.paginationwithrecyclerview.networking

import com.example.paginationwithrecyclerview.models.UserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/users")
    fun getUsers(@Query("page") page: Int = 1): Call<UserData>

}