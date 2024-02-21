package dima.inc.singlemoduletemplate.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dima.inc.singlemoduletemplate.common.model.RequestStateHolder
import dima.inc.singlemoduletemplate.domain.models.MastodonInfo
import dima.inc.singlemoduletemplate.domain.usecases.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val useCase: UseCase,
) : ViewModel() {

    val requestStateHolder = RequestStateHolder()

    val visibleUIDataState = MutableStateFlow<List<MastodonInfo>?>(null)

    fun getInstance() {
        viewModelScope.launch {
            requestStateHolder.emitLoadingState()
            requestStateHolder.defaultRequestHandler(
                useCase(),
                onSuccess = { data ->
                    visibleUIDataState.value = data
                }
            )
        }
    }
}