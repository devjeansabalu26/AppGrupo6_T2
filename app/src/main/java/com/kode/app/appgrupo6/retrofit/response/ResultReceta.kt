package com.kode.app.appgrupo6.retrofit.response

data class ResultReceta(
    var recipes: List<Receta>,
    var total: Int,
    var skip: Int,
    var limit: Int
)
