package com.nikasov.domain.entity

data class Track(
    val id: String,
    val name: String,
    val artistName: String,
    val artistId: String,
    val albumId: String,
    val albumName: String,
    val trackShareUrl: String
)
