package com.flamyoad.listenmoe.com.flamyoad.listenmoe.model

import kotlinx.serialization.Serializable

@Serializable
data class Song(
    val id: Int = 0,
    val title: String? = null,
    val titleRomaji: String? = null,
    val artists: List<SongDescriptor>? = null,
    val sources: List<SongDescriptor>? = null,
    val albums: List<SongDescriptor>? = null,
    val duration: Int = 0,
    val enabled: Boolean = false,
    val favourite: Boolean = false,
    val favouritedAt: Long? = null,
)