package dima.inc.singlemoduletemplate.data.api

import dima.inc.singlemoduletemplate.BuildConfig
import dima.inc.singlemoduletemplate.domain.models.Instance
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api{

    @GET("sample")
    @Headers("Authorization: Bearer ${BuildConfig.API_TOKEN}")
    suspend fun getRandomSamples(count: Int): List<Instance>
}