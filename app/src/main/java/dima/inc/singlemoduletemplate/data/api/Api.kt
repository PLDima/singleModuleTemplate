package dima.inc.singlemoduletemplate.data.api

import retrofit2.http.GET

interface Api{

    @GET("sample")
    fun getRandomSamples()
}