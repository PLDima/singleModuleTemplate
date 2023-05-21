package dima.inc.singlemoduletemplate.common.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RequestStateHolder {

    private val internalStateHolderFlow = MutableStateFlow<Result<*>>(Result.Success(Unit))

    fun emitLoadingState(state: Boolean = true) {
        internalStateHolderFlow.value = Result.Loading(state)
    }

    fun <T> emitState(result: Result<T>) {
        internalStateHolderFlow.value = result
    }

    fun setDefaultState() {
        internalStateHolderFlow.value = Result.Success(Unit)
    }

    fun getState() = internalStateHolderFlow.asStateFlow()

    fun <T> defaultRequestHandler(
        data: Result<T>,
        onSuccess: (data: T) -> Unit,
        onErrorAction: (code: Int, message: String) -> Unit = { code, message ->
            internalStateHolderFlow.value = Result.Error(code, message)
        },
        onFailure: (exception: Throwable) -> Unit = { exception ->
            internalStateHolderFlow.value = Result.Failure(exception)
        },
    ) {
        when (data) {
            is Result.Success -> {
                internalStateHolderFlow.value = Result.Success(Unit)
                onSuccess(data.data)
            }
            is Result.Error -> {
                onErrorAction(data.code, data.message)
            }
            is Result.Failure -> {
                onFailure(data.exception)
            }

            else -> {}
        }
    }
}