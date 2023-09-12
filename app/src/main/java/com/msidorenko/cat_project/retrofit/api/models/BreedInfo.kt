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

    @SerializedName("cfa_url")
    @Expose
    val cfaUrl: String? = null,

    @SerializedName("vetstreet_url")
    @Expose
    val vetstreetUrl: String? = null,

    @SerializedName("vcahospitals_url")
    @Expose
    val vcahospitalsUrl: String? = null,

    @SerializedName("temperament")
    @Expose
    val temperament: String? = null,

    @SerializedName("origin")
    @Expose
    val origin: String? = null,

    @SerializedName("country_codes")
    @Expose
    val countryCodes: String? = null,

    @SerializedName("country_code")
    @Expose
    val countryCode: String? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null,

    @SerializedName("life_span")
    @Expose
    val lifeSpan: String? = null,

    @SerializedName("indoor")
    @Expose
    val indoor: Int? = null,

    @SerializedName("lap")
    @Expose
    val lap: Int? = null,

    @SerializedName("alt_names")
    @Expose
    val altNames: String? = null,

    @SerializedName("adaptability")
    @Expose
    val adaptability: Int? = null,

    @SerializedName("affection_level")
    @Expose
    val affectionLevel: Int? = null,

    @SerializedName("child_friendly")
    @Expose
    val childFriendly: Int? = null,

    @SerializedName("dog_friendly")
    @Expose
    val dogFriendly: Int? = null,

    @SerializedName("energy_level")
    @Expose
    val energyLevel: Int? = null,

    @SerializedName("grooming")
    @Expose
    val grooming: Int? = null,

    @SerializedName("health_issues")
    @Expose
    val healthIssues: Int? = null,

    @SerializedName("intelligence")
    @Expose
    val intelligence: Int? = null,

    @SerializedName("shedding_level")
    @Expose
    val sheddingLevel: Int? = null,

    @SerializedName("social_needs")
    @Expose
    val socialNeeds: Int? = null,

    @SerializedName("stranger_friendly")
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

    @SerializedName("suppressed_tail")
    @Expose
    val suppressedTail: Int? = null,

    @SerializedName("short_legs")
    @Expose
    val shortLegs: Int? = null,

    @SerializedName("wikipedia_url")
    @Expose
    val wikipediaUrl: String? = null,

    @SerializedName("hypoallergenic")
    @Expose
    val hypoallergenic: Int? = null,

    @SerializedName("reference_image_id")
    @Expose
    val referenceImageId: String? = null,
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
