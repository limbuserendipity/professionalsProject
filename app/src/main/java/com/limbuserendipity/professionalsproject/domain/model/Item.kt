package com.limbuserendipity.professionalsproject.domain.model

data class Item(
    val title : String,
    val price : String,
    val imagePath : Int,
    var isFavorite : Boolean = false,
    var isBestSeller : Boolean = false
)
