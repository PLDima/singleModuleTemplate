package dima.inc.stardartarchitecture.ui.main.common.utils

sealed class RequestResult<out T> {
    data class Success<out T >(val data: T) : RequestResult<T>()
    data class Failure(val exception: Throwable) : RequestResult<Nothing>()
    data class Error(val code: Int, val message: String) : RequestResult<Nothing>()
    data class Loading(val state: Boolean) : RequestResult<Nothing>()
    class IDLE : RequestResult<Nothing>()
}