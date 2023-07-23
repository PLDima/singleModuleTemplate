package dima.inc.singlemoduletemplate.content.details_screen

import androidx.lifecycle.ViewModel
import dima.inc.singlemoduletemplate.data.models.Video
import kotlinx.coroutines.flow.StateFlow

abstract class VideoDetailsViewModel: ViewModel() {

    abstract val relatedVideoList: StateFlow<List<Video>>

    abstract fun loadRelatedVideoList(video: Video?)
}