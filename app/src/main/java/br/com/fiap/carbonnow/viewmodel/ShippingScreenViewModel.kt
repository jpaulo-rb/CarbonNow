package br.com.fiap.carbonnow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal

class ShippingScreenViewModel: ViewModel() {

    private val _weight_value = MutableLiveData<BigDecimal>();
    val weight_value: LiveData<BigDecimal> = _weight_value

    private val _distance_value = MutableLiveData<BigDecimal>();
    val distance_value: LiveData<BigDecimal> = _distance_value

    private val _transport_method = MutableLiveData<String>();
    val transport_method: LiveData<String> = _transport_method

    private val _carbon_g = MutableLiveData<BigDecimal>();
    val carbon_g: LiveData<BigDecimal> = _carbon_g

    private val _carbon_lb = MutableLiveData<BigDecimal>();
    val carbon_lb: LiveData<BigDecimal> = _carbon_lb

    private val _carbon_kg = MutableLiveData<BigDecimal>();
    val carbon_kg: LiveData<BigDecimal> = _carbon_kg

    private val _carbon_mt = MutableLiveData<BigDecimal>();
    val carbon_mt: LiveData<BigDecimal> = _carbon_mt


    fun onWeightValueChange(weightValue: BigDecimal) {
        _weight_value.value = weightValue
    }

    fun onDistanceValueChange(distanceValue: BigDecimal) {
        _distance_value.value = distanceValue
    }

    fun onTransportMethodValueChange(transportMethod: String) {
        _transport_method.value = transportMethod
    }

    fun onCarbonGChange(carbonG: BigDecimal) {
        _carbon_g.value = carbonG
    }

    fun onCarbonLbValueChange(carbonLb: BigDecimal) {
        _carbon_lb.value = carbonLb
    }

    fun onCarbonKgChange(carbonKg: BigDecimal) {
        _carbon_kg.value = carbonKg
    }

    fun onCarbonMtValueChange(carbonMt: BigDecimal) {
        _carbon_mt.value = carbonMt
    }
}