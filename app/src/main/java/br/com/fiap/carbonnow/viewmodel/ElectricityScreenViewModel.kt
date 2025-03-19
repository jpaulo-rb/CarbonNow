package br.com.fiap.carbonnow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal

class ElectricityScreenViewModel: ViewModel() {

    private val _electricity_value = MutableLiveData<BigDecimal>();
    val electricity_value: LiveData<BigDecimal> = _electricity_value

    private val _carbon_g = MutableLiveData<BigDecimal>();
    val carbon_g: LiveData<BigDecimal> = _carbon_g

    private val _carbon_lb = MutableLiveData<BigDecimal>();
    val carbon_lb: LiveData<BigDecimal> = _carbon_lb

    private val _carbon_kg = MutableLiveData<BigDecimal>();
    val carbon_kg: LiveData<BigDecimal> = _carbon_kg

    private val _carbon_mt = MutableLiveData<BigDecimal>();
    val carbon_mt: LiveData<BigDecimal> = _carbon_mt

    fun onElectricityValueChange(value: BigDecimal) {
        _electricity_value.value = value
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