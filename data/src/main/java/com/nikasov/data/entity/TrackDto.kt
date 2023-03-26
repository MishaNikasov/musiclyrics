package com.nikasov.data.entity

import com.google.gson.annotations.SerializedName

data class TrackDto(
    @SerializedName("track_id")
    val id: String?,
    @SerializedName("track_name")
    val name: String?,
    @SerializedName("artist_name")
    val artistName: String?,
    @SerializedName("album_id")
    val albumId: String?,
    @SerializedName("album_name")
    val albumName: String?,
    @SerializedName("artist_id")
    val artistId: String?,
    @SerializedName("track_share_url")
    val trackShareUrl: String?,
)