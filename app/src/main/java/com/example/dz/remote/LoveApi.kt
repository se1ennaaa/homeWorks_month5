package com.example.dz.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPresentage")
    fun getPercentage(
        @Query("fname")firstName:String,
        @Query("sname")secondName:String,
        @Header("X-RapidApi-Key")key:String="78bb8ecc8dmsha71f7db1db6c66cp1338f5jsn2ae3",
        @Header("X-RapidApi-Host")host:String= "love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}