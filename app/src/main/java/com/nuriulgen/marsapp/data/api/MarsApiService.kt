package com.nuriulgen.marsapp.data.api

import com.nuriulgen.marsapp.presentation.home.model.RealeStateModel
import retrofit2.Call
import retrofit2.http.GET

interface MarsApiService {
    @GET("realestate")
    fun getProperties(): Call<List<RealeStateModel>>
}