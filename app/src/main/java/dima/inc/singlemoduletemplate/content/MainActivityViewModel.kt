package dima.inc.singlemoduletemplate.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dima.inc.singlemoduletemplate.common.model.RequestStateHolder
import dima.inc.singlemoduletemplate.domain.usecases.UseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    val requestStateHolder = RequestStateHolder()

    fun getInstance(){
        viewModelScope.launch {
            useCase()
        }
    }
}