package com.alexandrebruno.listphotos.data.di

import com.alexandrebruno.listphotos.MainViewModel
import com.alexandrebruno.listphotos.data.Service

import com.alexandrebruno.listphotos.data.repository.PhotosRepositoryImp
import com.alexandrebruno.listphotos.domain.repository.PhotosRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    factory<PhotosRepository>{
        PhotosRepositoryImp(get())
    }

    viewModel {
        MainViewModel(
            get()
        )
    }

    single<Service>{
        com.alexandrebruno.listphotos.data.config.Network
    }
}