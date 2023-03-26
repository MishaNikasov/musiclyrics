package com.nikasov.data.repository

import com.nikasov.common.utils.DataState
import com.nikasov.data.api.MusixmatchApi
import com.nikasov.data.mapper.TrackMapper
import com.nikasov.data.repository.base.BaseRepository
import com.nikasov.domain.entity.Track
import javax.inject.Inject

class MusixmatchRepository @Inject constructor(
    private val musixmatchApi: MusixmatchApi,
    private val trackMapper: TrackMapper
) : BaseRepository() {

    suspend fun search(searchText: String): DataState<List<Track>> {
        return obtain(
            request = musixmatchApi.search(searchText),
            mapper = { trackMapper.mapList(it?.message?.body?.list?.map { it.track }) }
        )
    }

    suspend fun getCharts() {
        musixmatchApi.getChartArtists(1, 1, "UA")
    }

}