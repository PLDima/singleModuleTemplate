package dima.inc.singlemoduletemplate.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dima.inc.singlemoduletemplate.BuildConfig
import dima.inc.singlemoduletemplate.data.api.Api
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApi(): Api =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).build().create(Api::class.java)
}