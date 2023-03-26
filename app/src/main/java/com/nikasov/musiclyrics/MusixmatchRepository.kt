package com.nikasov.musiclyrics

import com.nikasov.data.api.MusixmatchApi
import javax.inject.Inject

class MusixmatchRepository @Inject constructor(
    private val musixmatchApi: MusixmatchApi
) {

    suspend fun getCharts() {
        musixmatchApi.getChartArtists(1, 1, "UA")
    }

}