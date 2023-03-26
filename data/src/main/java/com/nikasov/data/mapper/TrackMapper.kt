package com.nikasov.data.mapper

import com.nikasov.data.entity.TrackDto
import com.nikasov.domain.entity.Track
import javax.inject.Inject

class TrackMapper @Inject constructor() {

    fun mapList(trackDtoList: List<TrackDto?>?): List<Track> {
        trackDtoList ?: return emptyList()
        return trackDtoList.mapNotNull { map(it) }
    }

    fun map(trackDto: TrackDto?): Track? {
        trackDto ?: return null
        return Track(
            id = trackDto.id.orEmpty(),
            name = trackDto.name.orEmpty(),
            artistName = trackDto.artistName.orEmpty(),
            artistId = trackDto.artistId.orEmpty(),
            albumId = trackDto.albumId.orEmpty(),
            albumName = trackDto.albumName.orEmpty(),
            trackShareUrl = trackDto.trackShareUrl.orEmpty(),
        )
    }

}