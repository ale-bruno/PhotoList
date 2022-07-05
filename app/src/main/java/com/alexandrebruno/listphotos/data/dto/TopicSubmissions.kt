package com.alexandrebruno.listphotos.data.dto


import com.google.gson.annotations.SerializedName

data class TopicSubmissions(
    @SerializedName("architecture")
    val architecture: Architecture,
    @SerializedName("business-work")
    val businessWork: BusinessWork,
    @SerializedName("3d-renders")
    val dRenders: DRenders,
    @SerializedName("interiors")
    val interiors: Interiors,
    @SerializedName("originalbydesign")
    val originalbydesign: Originalbydesign,
    @SerializedName("street-photography")
    val streetPhotography: StreetPhotography,
    @SerializedName("wallpapers")
    val wallpapers: Wallpapers,
    @SerializedName("work-from-home")
    val workFromHome: WorkFromHome
)