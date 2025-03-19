package br.com.fiap.carbonnow.service

import br.com.fiap.carbonnow.model.Electricity
import br.com.fiap.carbonnow.model.Estimate
import br.com.fiap.carbonnow.model.Shipping
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface EstimateService {

    @POST("estimates")
    fun calcElectricity(
        @Header("Authorization") authorization: String,
        @Body electricity: Electricity
    ): Call<Estimate.ApiResponse<Electricity>>

    @POST("estimates")
    fun calcShipping(
        @Header("Authorization") authorization: String,
        @Body shipping: Shipping
    ): Call<Estimate.ApiResponse<Shipping>>

}