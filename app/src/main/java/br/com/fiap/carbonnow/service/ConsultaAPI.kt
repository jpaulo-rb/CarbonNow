package br.com.fiap.carbonnow.service

import android.util.Log
import br.com.fiap.carbonnow.viewmodel.ElectricityScreenViewModel
import br.com.fiap.carbonnow.viewmodel.ShippingScreenViewModel
import br.com.fiap.carbonnow.model.Electricity
import br.com.fiap.carbonnow.model.Estimate
import br.com.fiap.carbonnow.model.Shipping
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val apiKey = "VupfF42jjvbfc0JYvswRXg"
private const val authHeader = "Bearer $apiKey"

fun calcElectricity(electricity: Electricity, electricityScreenViewModel: ElectricityScreenViewModel) {

    val call = RetrofitFactory().calcCO2Service().calcElectricity(
        electricity = electricity, authorization = authHeader
    )

    call.enqueue(object : Callback<Estimate.ApiResponse<Electricity>> {
        override fun onResponse(
            call: Call<Estimate.ApiResponse<Electricity>>,
            response: Response<Estimate.ApiResponse<Electricity>>
        ) {
            Log.i("Cleiton", "Response -> ${Gson().toJson(electricity)}")
            electricityScreenViewModel.onElectricityValueChange(response.body()!!.data.attributes.electricity_value)
            electricityScreenViewModel.onCarbonGChange(response.body()!!.data.attributes.carbon_g)
            electricityScreenViewModel.onCarbonMtValueChange(response.body()!!.data.attributes.carbon_mt)
            electricityScreenViewModel.onCarbonKgChange(response.body()!!.data.attributes.carbon_kg)
            electricityScreenViewModel.onCarbonLbValueChange(response.body()!!.data.attributes.carbon_lb)
        }
        override fun onFailure(call: Call<Estimate.ApiResponse<Electricity>>, t: Throwable) {
            Log.i("Cleiton", "Failure -> $t")
        }
    })
}

fun calcShpping(shipping: Shipping, shippingScreenViewModel: ShippingScreenViewModel) {

    val call = RetrofitFactory().calcCO2Service().calcShipping(
        shipping = shipping, authorization = authHeader
    )

    call.enqueue(object : Callback<Estimate.ApiResponse<Shipping>> {
        override fun onResponse(
            call: Call<Estimate.ApiResponse<Shipping>>,
            response: Response<Estimate.ApiResponse<Shipping>>
        ) {
            Log.i("Cleiton", "Response -> ${Gson().toJson(shipping)}")
            shippingScreenViewModel.onWeightValueChange(response.body()!!.data.attributes.weight_value)
            shippingScreenViewModel.onDistanceValueChange(response.body()!!.data.attributes.distance_value)
            shippingScreenViewModel.onCarbonGChange(response.body()!!.data.attributes.carbon_g)
            shippingScreenViewModel.onCarbonMtValueChange(response.body()!!.data.attributes.carbon_mt)
            shippingScreenViewModel.onCarbonKgChange(response.body()!!.data.attributes.carbon_kg)
            shippingScreenViewModel.onCarbonLbValueChange(response.body()!!.data.attributes.carbon_lb)
        }
        override fun onFailure(call: Call<Estimate.ApiResponse<Shipping>>, t: Throwable) {
            Log.i("Cleiton", "Failure -> $t")
        }
    })
}