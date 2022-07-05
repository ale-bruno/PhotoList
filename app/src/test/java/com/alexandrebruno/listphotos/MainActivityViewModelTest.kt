package com.alexandrebruno.listphotos

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.alexandrebruno.listphotos.domain.repository.PhotosRepository
import com.alexandrebruno.listphotos.domain.repository.model.PhotoListResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainActivityViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @OptIn(DelicateCoroutinesApi::class)
    private val testDispatcher = newSingleThreadContext("UI thread")
    private val photosRepository: PhotosRepository = mockk()


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.close()
    }

    @Test
    fun `when getPhotos is called then it should call repository to fetch cat photos`(){
        val photos = listOf<PhotoListResponse>()

        coEvery { photosRepository.fetchPhoto() } returns  photos
        instantiate().getPhotos()

        coVerify { photosRepository.fetchPhoto() }

    }

    private fun instantiate(): MainViewModel {
        return MainViewModel(photosRepository)
    }
}