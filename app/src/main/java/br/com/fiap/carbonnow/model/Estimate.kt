package br.com.fiap.carbonnow.model

class Estimate {

    class ApiResponse<TModel>(
        val data: ApiData<TModel>
    )

    class ApiData<TModel>(
        val id: String,
        val type: String,
        val attributes: TModel
    )
}