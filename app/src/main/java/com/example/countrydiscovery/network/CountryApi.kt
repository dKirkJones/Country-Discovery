package com.example.countrydiscovery.network

import com.example.countrydiscovery.data.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryApi {
    @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/")
    suspend fun getDataFromAPI(): Response<List<Country.CountryItem>>
}