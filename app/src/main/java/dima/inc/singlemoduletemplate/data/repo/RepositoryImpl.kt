package dima.inc.singlemoduletemplate.data.repo

import dima.inc.singlemoduletemplate.data.api.datasource.YouTubeDataSource
import dima.inc.singlemoduletemplate.data.models.Video
import dima.inc.singlemoduletemplate.domain.repo.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val youTubeDataSource: YouTubeDataSource
) :  Repository {

    override suspend fun getPopularVideo() = youTubeDataSource.getPopularVideo()

    override suspend fun searchVideoList(videoName: String) = youTubeDataSource.getVideoByName(videoName)

    override suspend fun getRelatedVideoList(video: Video) = youTubeDataSource.getRelatedVideoList(video)
}