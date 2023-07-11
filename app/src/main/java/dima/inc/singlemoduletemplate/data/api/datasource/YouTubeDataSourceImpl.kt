package dima.inc.singlemoduletemplate.data.api.datasource

import android.util.Log
import com.google.api.services.youtube.YouTube
import com.google.api.services.youtube.model.SearchResult
import dima.inc.singlemoduletemplate.BuildConfig
import dima.inc.singlemoduletemplate.common.model.NoInternetConnectionException
import dima.inc.singlemoduletemplate.data.models.Video
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject
import com.google.api.services.youtube.model.Video as YouTubeVideo

class YouTubeDataSourceImpl @Inject constructor(private val youTube: YouTube) :
    YouTubeDataSource {

    private var popularPageToken: String? = null
    private var searchPageToken: String? = null
    private var relatedPageToken: String? = null
    private var savedQuery: String? = null
    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        when (exception) {
            is UnknownHostException -> {
                Log.e("Error", "Catch error in data layer: ", exception)
                throw NoInternetConnectionException()
            }
            is ConnectException -> {
                Log.e("Error", "Connection refused: ", exception)
                throw NoInternetConnectionException()
            }
            is SocketTimeoutException -> {
                Log.e("Error", "Website is down: ", exception)
                throw NoInternetConnectionException()
            }
        }
    }

    private val coroutineContext = Dispatchers.IO + errorHandler

    override suspend fun getPopularVideo() =
        withContext(coroutineContext) {
            youTube
                .videos()
                .list("snippet,contentDetails,statistics")
                .setChart("mostPopular")
                .apply { if (popularPageToken != null) pageToken = popularPageToken }
                .setMaxResults(20)
                .setKey(BuildConfig.API_KEY)
                .execute()
                .apply { popularPageToken = nextPageToken }
                .items
                .map { item ->
                    item.getVideo()
                }
        }

    override suspend fun getVideoByName(query: String) =
        withContext(coroutineContext) {
            if (query != savedQuery) {
                savedQuery = query
                searchPageToken = null
            }
            youTube
                .search()
                .list("snippet")
                .apply { if (searchPageToken != null) pageToken = searchPageToken }
                .setKey(BuildConfig.API_KEY)
                .setMaxResults(20)
                .setQ(query)
                .setType("video")
                .execute()
                .apply { searchPageToken = nextPageToken }
                .items
                .mapNotNull { getVideoInfo(it)?.getVideo() }
        }

    override suspend fun getRelatedVideoList(video: Video) =
        withContext(coroutineContext) {
            youTube
                .search()
                .list("snippet")
                .apply { if (relatedPageToken != null) pageToken = relatedPageToken }
                .setKey(BuildConfig.API_KEY)
                .setMaxResults(20)
                .setRelatedToVideoId(video.videoId)
                .setType("video")
                .execute()
                .apply { relatedPageToken = nextPageToken }
                .items
                .mapNotNull { getVideoInfo(it)?.getVideo() }
        }

    private fun getVideoInfo(item: SearchResult) = youTube
        .videos()
        .list("snippet,contentDetails,statistics")
        .setKey(BuildConfig.API_KEY)
        .setId(item.id.videoId)
        .execute()
        .items
        .firstOrNull()

    private fun YouTubeVideo.getVideo(): Video {
        Log.w("Logs", "icon Sizes: height ${this.snippet.thumbnails.medium.height} width ${this.snippet.thumbnails.medium.width}")
        return Video(
            name = this.snippet.title,
            description = this.snippet.description,
            videoId = this.id,
            iconUri = this.snippet.thumbnails.medium.url,
            views = this.statistics.viewCount?.toLong() ?: 0,
            likes = this.statistics.likeCount?.toLong() ?: 0,
            dislikes = this.statistics.dislikeCount?.toLong() ?: 0,
        )
    }
}
