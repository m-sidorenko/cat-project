package com.msidorenko.cat_project.model

import com.msidorenko.cat_project.retrofit.api.models.BreedInfo

sealed class Response(
    val breedList: List<BreedInfo>?
) {
    class Success(breedList: List<BreedInfo>?) : Response(breedList)
    class Error() : Response(null)
}



