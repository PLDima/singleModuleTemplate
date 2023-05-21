package dima.inc.singlemoduletemplate.common.utils

import retrofit2.HttpException
import retrofit2.Response
import dima.inc.singlemoduletemplate.common.model.Result

suspend fun <T, E> safeApiCallWithResult(
    dataMapper: (T) -> E,
    call: suspend () -> Response<T>
): Result<E> {
    return try {
        val response: Response<T> = call()
        if (response.isSuccessful) {
            Result.Success(data = dataMapper(response.body()!!))
        } else {
            Result.Error(
                message = response.message(),
                code = response.code()
            )
        }
    } catch (ex: Exception) {
        return when (ex) {
            is HttpException -> Result.Error(ex.code(), ex.message())
            else -> Result.Failure(ex)
        }
    }
}