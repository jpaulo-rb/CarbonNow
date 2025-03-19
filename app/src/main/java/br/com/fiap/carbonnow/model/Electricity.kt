package br.com.fiap.carbonnow.model

import java.math.BigDecimal

class Electricity {
    val type = "electricity"
    val electricity_unit = "mhw"
    var electricity_value: BigDecimal = BigDecimal(0.0)
    val country = "us"

    val state: String = ""

    // Retorno API
    val carbon_g: BigDecimal = BigDecimal(0.0)
    val carbon_lb: BigDecimal = BigDecimal(0.0)
    val carbon_kg: BigDecimal = BigDecimal(0.0)
    val carbon_mt: BigDecimal = BigDecimal(0.0)
}