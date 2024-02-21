package dima.inc.singlemoduletemplate.data.api

import dima.inc.singlemoduletemplate.BuildConfig
import dima.inc.singlemoduletemplate.domain.models.ResponseResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {

    @GET("instances/sample")
    @Headers("Authorization: Bearer ${BuildConfig.API_TOKEN}")
    suspend fun getRandomSamples(@Query(value = "count") count: Int): Response<ResponseResult>

    @GET("apps")
    @Headers("Authorization: Bearer ${BuildConfig.API_TOKEN}")
    suspend fun registerApp(): ResponseResult

    @GET("instances/search")
    @Headers("Authorization: Bearer ${BuildConfig.API_TOKEN}")
    suspend fun getSearchResult(
        @Query(value = "count") count: Int,
        @Query(value = "query") query: String
    ): ResponseResult
}