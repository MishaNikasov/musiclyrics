package com.nikasov.data.api

import com.nikasov.data.entity.TrackSearchDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MusixmatchApi {

    @GET("chart.artists.get")
    suspend fun getChartArtists(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int,
        @Query("country") country: String
    ): Response<Unit>

    @GET("track.search")
    suspend fun search(
        @Query("q_track") track: String,
        @Query("q_artist") artist: String = "",
        @Query("page") page: Int = 1,
        @Query("page_size") page_size: Int = 10
    ): Response<TrackSearchDto?>
}