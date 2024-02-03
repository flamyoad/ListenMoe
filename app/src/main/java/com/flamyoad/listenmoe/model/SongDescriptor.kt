package com.flamyoad.listenmoe.com.flamyoad.listenmoe.model

import kotlinx.serialization.Serializable

@Serializable
data class SongDescriptor(
    val name: String? = null,
    val nameRomaji: String? = null,
    val image: String? = null,
)