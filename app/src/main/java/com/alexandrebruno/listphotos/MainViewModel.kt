package com.alexandrebruno.listphotos

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexandrebruno.listphotos.domain.repository.PhotosRepository
import com.alexandrebruno.listphotos.domain.repository.model.PhotoListResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val photosRepository: PhotosRepository) : ViewModel() {


    val mutablePhotos: MutableState<List<PhotoListResponse>> = mutableStateOf(listOf())

    init {
        getPhotos()
    }

    fun getPhotos(){
        CoroutineScope(Dispatchers.IO).launch {
            val result = withContext(Dispatchers.IO) {
                photosRepository.fetchPhoto()
            }
            mutablePhotos.value = result
        }
    }
}




