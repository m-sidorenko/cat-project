package com.msidorenko.cat_project.retrofit.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageWithBreedInfo(
    @SerializedName("id")
    @Expose
    val id: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("breeds")
    @Expose
    val breeds: List<BreedInfo>? = null,

    @SerializedName("width")
    @Expose
    val width: Int? = null,

    @SerializedName("height")
    @Expose
    val height: Int? = null,
)
