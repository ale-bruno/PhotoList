package com.alexandrebruno.listphotos.data.repository


import com.alexandrebruno.listphotos.data.Service
import com.alexandrebruno.listphotos.data.dto.PhotosItem
import com.alexandrebruno.listphotos.domain.repository.PhotosRepository
import com.alexandrebruno.listphotos.domain.repository.model.PhotoListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PhotosRepositoryImp constructor(
    private val service: Service
) : PhotosRepository {

    override suspend fun fetchPhoto(): List<PhotoListResponse> {
        val page: String = "1"
        val client_id: String = "52ed5e63ad1915fed2bbfd2326aade6b8549b050fc8367a7c105567476df2a81"

        return withContext(Dispatchers.IO){
            service.fetchPhotos(page, client_id)
        }
    }

}