package com.alexandrebruno.listphotos.data.dto


import com.google.gson.annotations.SerializedName

data class WorkFromHome(
    @SerializedName("approved_on")
    val approvedOn: String,
    @SerializedName("status")
    val status: String
)