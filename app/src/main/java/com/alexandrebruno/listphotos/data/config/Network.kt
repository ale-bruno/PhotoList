package com.alexandrebruno.listphotos.data.config

import com.alexandrebruno.listphotos.data.Service
import com.alexandrebruno.listphotos.domain.repository.model.PhotoListResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network : Service{

     private const val BASE_URL = "https://api.unsplash.com/"

     private val client = OkHttpClient.Builder().build()

     private fun getRetrofit(): Retrofit {
          return Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .client(client)
               .build()
     }

     private val api: Service = getRetrofit().create(Service::class.java)
     override suspend fun fetchPhotos(
          page: String,
          client: String
     ): List<PhotoListResponse> {
          return api.fetchPhotos(page, client)
     }


}