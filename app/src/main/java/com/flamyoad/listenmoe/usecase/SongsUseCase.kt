package com.flamyoad.listenmoe.com.flamyoad.listenmoe.usecase

import com.flamyoad.listenmoe.SongQuery
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.api.SongsApi
import com.flamyoad.listenmoe.com.flamyoad.listenmoe.model.Song
import com.flamyoad.listenmoe.core.CustomDispatcher
import kotlinx.coroutines.withContext

interface SongsUseCase {
    suspend fun getSongDetail(songId: Int): Result<Song>
}

class SongsUseCaseImpl(
    private val api: SongsApi,
    private val dispatchers: CustomDispatcher,
) : SongsUseCase {

    override suspend fun getSongDetail(songId: Int): Result<Song> =
        withContext(dispatchers.io()) {
            runCatching {
                api.getSongDetails(songId)!!.toDomain() // Try to use Either<L,R>
            }
        }

    private fun SongQuery.Data.toDomain(): Song {
        // Map tee fields
        return Song()
    }
}
