package com.nikasov.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusixmatchApi {

    @GET("chart.artists.get")
    suspend fun getChartArtists(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
        @Query("country") country: String,
    ): Response<Unit>

}