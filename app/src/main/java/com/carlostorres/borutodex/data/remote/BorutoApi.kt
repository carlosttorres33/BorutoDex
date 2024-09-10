package com.carlostorres.borutodex.data.remote

import com.carlostorres.borutodex.data.model.ApiResponse
import com.carlostorres.borutodex.util.Constants.GET_ALL_HEROES_ENDPOINT
import com.carlostorres.borutodex.util.Constants.SEARCH_HEROES_ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface BorutoApi {

    @GET(GET_ALL_HEROES_ENDPOINT)
    suspend fun getAllHeroes(
        @Query("page") page : Int = 1
    ) : ApiResponse

    @GET(SEARCH_HEROES_ENDPOINT)
    suspend fun searchHeroes(
        @Query("name") name : String
    ) : ApiResponse

}