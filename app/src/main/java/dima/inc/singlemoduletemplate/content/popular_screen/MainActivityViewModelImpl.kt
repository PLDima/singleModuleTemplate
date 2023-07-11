package dima.inc.singlemoduletemplate.content.popular_screen

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dima.inc.singlemoduletemplate.common.model.RequestStateHolder
import dima.inc.singlemoduletemplate.data.models.Video
import dima.inc.singlemoduletemplate.domain.usecases.getPopularVideo.GetPopularVideoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModelImpl @Inject constructor(
    private val getPopularVideoUseCase: GetPopularVideoUseCase,
) : MainActivityViewModel() {

    override val videoList = MutableStateFlow<List<Video>>(emptyList())

    fun loadVideoList() {
        viewModelScope.launch {
            videoList.value = getPopularVideoUseCase()
        }
    }

    fun searchVideoByName(query: String) {
        // TODO add implementation for search
    }

    val requestStateHolder = RequestStateHolder()
}