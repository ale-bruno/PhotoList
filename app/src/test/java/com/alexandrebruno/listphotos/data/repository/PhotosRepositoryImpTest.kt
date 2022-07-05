package com.alexandrebruno.listphotos.data.repository

import com.alexandrebruno.listphotos.domain.repository.model.PhotoListResponse
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

internal class PhotosRepositoryImpTest {

    @OptIn(DelicateCoroutinesApi::class)
    private val testDispatcher = newSingleThreadContext("UI thread")
    private val network: com.alexandrebruno.listphotos.data.config.Network = mockk (relaxed = true)

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
    fun `when fetchPhotos is called then it should call service fetchPhotos`(){
        val page: String = "1"
        val client_id: String = "52ed5e63ad1915fed2bbfd2326aade6b8549b050fc8367a7c105567476df2a81"

        val photos = listOf<PhotoListResponse>()

        coEvery { network.fetchPhotos(page, client_id) } returns photos

        runBlocking {
            PhotosRepositoryImp(network).fetchPhoto()
        }

        coVerify { network.fetchPhotos(page, client_id)}
    }
}