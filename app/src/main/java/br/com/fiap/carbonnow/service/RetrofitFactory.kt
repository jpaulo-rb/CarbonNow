package br.com.fiap.carbonnow.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val retrofitFactory = Retrofit
        .Builder()
        .baseUrl("https://www.carboninterface.com/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun calcCO2Service(): EstimateService {
        return retrofitFactory.create(EstimateService::class.java)
    }
}