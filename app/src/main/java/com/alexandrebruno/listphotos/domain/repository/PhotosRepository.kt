package com.alexandrebruno.listphotos.domain.repository

import com.alexandrebruno.listphotos.data.dto.Photos
import com.alexandrebruno.listphotos.data.dto.PhotosItem
import com.alexandrebruno.listphotos.domain.repository.model.PhotoListResponse

interface PhotosRepository {

    suspend fun fetchPhoto() : List<PhotoListResponse>
}