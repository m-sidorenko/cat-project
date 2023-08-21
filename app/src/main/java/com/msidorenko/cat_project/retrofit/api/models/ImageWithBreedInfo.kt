package com.msidorenko.cat_project.retrofit.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ImageWithBreedInfo(
    @SerializedName("id")
    @Expose
    private val id: String? = null,

    @SerializedName("url")
    @Expose
    private val url: String? = null,

    @SerializedName("breeds")
    @Expose
    private val breeds: List<BreedInfo>? = null,

    @SerializedName("width")
    @Expose
    private val width: Int? = null,

    @SerializedName("height")
    @Expose
    private val height: Int? = null,
)

