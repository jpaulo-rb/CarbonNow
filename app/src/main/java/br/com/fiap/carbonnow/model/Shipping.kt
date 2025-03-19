package br.com.fiap.carbonnow.model

import java.math.BigDecimal

class Shipping {
    val type = "shipping"
    val weight_unit = "kg"
    var weight_value: BigDecimal = BigDecimal(0.0)
    val distance_unit = "km"
    var distance_value: BigDecimal = BigDecimal(0.0)
    var transport_method: String = ""

    // Retorno API
    val carbon_g: BigDecimal = BigDecimal(0.0)
    val carbon_lb: BigDecimal = BigDecimal(0.0)
    val carbon_kg: BigDecimal = BigDecimal(0.0)
    val carbon_mt: BigDecimal = BigDecimal(0.0)
}