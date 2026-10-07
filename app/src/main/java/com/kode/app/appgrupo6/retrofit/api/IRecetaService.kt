package com.kode.app.appgrupo6.retrofit.api

import com.kode.app.appgrupo6.retrofit.response.ResultReceta
import retrofit2.Call
import retrofit2.http.GET

interface IRecetaService {
    @GET("recipes")
    fun obtenerRecetas() : Call<ResultReceta>

}
