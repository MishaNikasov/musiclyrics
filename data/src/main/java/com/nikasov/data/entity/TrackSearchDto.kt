package com.nikasov.data.entity

import com.google.gson.annotations.SerializedName

data class TrackSearchDto(
    @SerializedName("message")
    val message: TrackSearchMessage?
)

data class TrackSearchMessage(
    @SerializedName("body")
    val body: TrackSearchBody?
)

data class TrackSearchBody(
    @SerializedName("track_list")
    val list: List<TrackWrapper>?
)

data class TrackWrapper(
    @SerializedName("track")
    val track: TrackDto?
)