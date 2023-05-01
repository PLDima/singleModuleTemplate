package dima.inc.singlemoduletemplate.common

import androidx.lifecycle.ViewModel
import dima.inc.stardartarchitecture.ui.main.common.utils.RequestResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class CommonViewModel: ViewModel() {

    private val internalStateHolderFlow = MutableStateFlow<RequestResult<*>>(RequestResult.Success(Unit))

    protected fun emitLoadingState(state: Boolean = true) {
        internalStateHolderFlow.value = RequestResult.Loading(state)
    }

    protected fun <T> emitState(result: RequestResult<T>) {
        internalStateHolderFlow.value = result
    }

    open fun setDefaultState() {
        internalStateHolderFlow.value = RequestResult.Success(Unit)
    }

    fun getState() = internalStateHolderFlow.asStateFlow()

    protected fun <T> RequestResult<T>.defaultRequestHandler(
        onSuccess: (data: T) -> Unit,
        onErrorAction: (code: Int, message: String) -> Unit = { code, message ->
            internalStateHolderFlow.value = RequestResult.Error(code, message)
        },
        onFailure: (exception: Throwable) -> Unit = { exception ->
            internalStateHolderFlow.value = RequestResult.Failure(exception)
        },
    ) {
        when (this) {
            is RequestResult.Success -> {
                internalStateHolderFlow.value = RequestResult.Success(Unit)
                onSuccess(this.data)
            }
            is RequestResult.Error -> {
                onErrorAction(this.code, this.message)
            }
            is RequestResult.Failure -> {
                onFailure(this.exception)
            }
            else -> {}
        }
    }
}