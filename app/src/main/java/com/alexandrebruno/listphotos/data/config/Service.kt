package com.alexandrebruno.listphotos.data

import com.alexandrebruno.listphotos.data.dto.PhotosItem
import com.alexandrebruno.listphotos.domain.repository.model.PhotoListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

//        https://api.unsplash.com/photos?page=1&client_id=52ed5e63ad1915fed2bbfd2326aade6b8549b050fc8367a7c105567476df2a81

    @GET("photos")
    suspend fun fetchPhotos(
        @Query("page") page: String,
        @Query("client_id") client: String
    ) : List<PhotoListResponse>

}