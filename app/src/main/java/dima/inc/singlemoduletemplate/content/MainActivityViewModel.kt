package dima.inc.singlemoduletemplate.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dima.inc.singlemoduletemplate.domain.repo.MastodonRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repo: MastodonRepository
) : ViewModel() {

    fun getInstance(){
        viewModelScope.launch {
            repo.getInstances()
        }
    }
}