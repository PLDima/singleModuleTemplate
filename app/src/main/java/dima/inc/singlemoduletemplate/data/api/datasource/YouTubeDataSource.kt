package dima.inc.singlemoduletemplate.data.api.datasource

import dima.inc.singlemoduletemplate.data.models.Video

interface YouTubeDataSource {

    suspend fun getPopularVideo(): List<Video>

    suspend fun getVideoByName(query: String): List<Video>

    suspend fun getRelatedVideoList(video: Video): List<Video>
}