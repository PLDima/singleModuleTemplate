package dima.inc.singlemoduletemplate.content.popular_screen

import androidx.lifecycle.ViewModel
import dima.inc.singlemoduletemplate.common.model.RequestStateHolder
import dima.inc.singlemoduletemplate.data.models.Video
import kotlinx.coroutines.flow.StateFlow

abstract class MainActivityViewModel : ViewModel() {

    abstract val videoList: StateFlow<List<Video>>

    abstract val requestStateHolder: RequestStateHolder

    abstract fun searchVideoByName(query: String)

    abstract fun loadVideoList()
}