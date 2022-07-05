package com.alexandrebruno.listphotos.data.dto


import com.google.gson.annotations.SerializedName

data class Wallpapers(
    @SerializedName("status")
    val status: String
)