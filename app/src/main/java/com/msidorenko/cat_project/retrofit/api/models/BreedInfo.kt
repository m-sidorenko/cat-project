package com.msidorenko.cat_project.retrofit.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BreedInfo(
    @SerializedName("weight")
    @Expose
    val weight: Weight? = null,

    @SerializedName("id")
    @Expose
    val id: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("cfaUrl")
    @Expose
    val cfaUrl: String? = null,

    @SerializedName("vetStreetUrl")
    @Expose
    val vetStreetUrl: String? = null,

    @SerializedName("vcaHospitalsUrl")
    @Expose
    val vcaHospitalsUrl: String? = null,

    @SerializedName("temperament")
    @Expose
    val temperament: String? = null,

    @SerializedName("origin")
    @Expose
    val origin: String? = null,

    @SerializedName("countryCodes")
    @Expose
    val countryCodes: String? = null,

    @SerializedName("countryCode")
    @Expose
    val countryCode: String? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null,

    @SerializedName("lifeSpan")
    @Expose
    val lifeSpan: String? = null,

    @SerializedName("indoor")
    @Expose
    val indoor: Int? = null,

    @SerializedName("lap")
    @Expose
    val lap: Int? = null,

    @SerializedName("altNames")
    @Expose
    val altNames: String? = null,

    @SerializedName("adaptability")
    @Expose
    val adaptability: Int? = null,

    @SerializedName("affectionLevel")
    @Expose
    val affectionLevel: Int? = null,

    @SerializedName("childFriendly")
    @Expose
    val childFriendly: Int? = null,

    @SerializedName("dogFriendly")
    @Expose
    val dogFriendly: Int? = null,

    @SerializedName("energyLevel")
    @Expose
    val energyLevel: Int? = null,

    @SerializedName("grooming")
    @Expose
    val grooming: Int? = null,

    @SerializedName("healthIssues")
    @Expose
    val healthIssues: Int? = null,

    @SerializedName("intelligence")
    @Expose
    val intelligence: Int? = null,

    @SerializedName("sheddingLevel")
    @Expose
    val sheddingLevel: Int? = null,

    @SerializedName("socialNeeds")
    @Expose
    val socialNeeds: Int? = null,

    @SerializedName("strangerFriendly")
    @Expose
    val strangerFriendly: Int? = null,

    @SerializedName("vocalisation")
    @Expose
    val vocalisation: Int? = null,

    @SerializedName("experimental")
    @Expose
    val experimental: Int? = null,

    @SerializedName("hairless")
    @Expose
    val hairless: Int? = null,

    @SerializedName("natural")
    @Expose
    val natural: Int? = null,

    @SerializedName("rare")
    @Expose
    val rare: Int? = null,

    @SerializedName("rex")
    @Expose
    val rex: Int? = null,

    @SerializedName("suppressedTail")
    @Expose
    val suppressedTail: Int? = null,

    @SerializedName("shortLegs")
    @Expose
    val shortLegs: Int? = null,

    @SerializedName("wikipediaUrl")
    @Expose
    val wikipediaUrl: String? = null,

    @SerializedName("hypoallergenic")
    @Expose
    val hypoallergenic: Int? = null,

    @SerializedName("referenceImageId")
    @Expose
    val referenceImageId: String? = null
) {

    data class Weight(
        @SerializedName("imperial")
        @Expose
        val imperial: String? = null,

        @SerializedName("metric")
        @Expose
        val metric: String? = null
    )
}
