package dima.inc.singlemoduletemplate.content.details_screen

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dima.inc.singlemoduletemplate.data.models.Video
import dima.inc.singlemoduletemplate.domain.usecases.getRelatedVideo.GetRelatedVideoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoDetailsViewModelImpl @Inject constructor(
    private val getRelatedVideoUseCase: GetRelatedVideoUseCase,
) : VideoDetailsViewModel() {


    override val relatedVideoList = MutableStateFlow<List<Video>>(emptyList())

    override fun loadRelatedVideoList(video: Video?) {
        viewModelScope.launch {
            relatedVideoList.value = getRelatedVideoUseCase(video ?: return@launch)
        }
    }
}