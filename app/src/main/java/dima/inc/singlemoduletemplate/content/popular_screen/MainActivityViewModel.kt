package dima.inc.singlemoduletemplate.content.popular_screen

import androidx.lifecycle.ViewModel
import dima.inc.singlemoduletemplate.data.models.Video
import kotlinx.coroutines.flow.StateFlow

abstract class MainActivityViewModel : ViewModel() {

    abstract val videoList: StateFlow<List<Video>>
}