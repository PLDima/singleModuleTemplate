package dima.inc.singlemoduletemplate.domain.repo

import dima.inc.singlemoduletemplate.data.models.Video

interface Repository {
    suspend fun getPopularVideo(): List<Video>
    suspend fun searchVideoList(videoName: String): List<Video>
    suspend fun getRelatedVideoList(video: Video): List<Video>
}