package dima.inc.singlemoduletemplate.di.modules

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dima.inc.singlemoduletemplate.BuildConfig
import dima.inc.singlemoduletemplate.common.utils.MoshiArrayListJsonAdapter
import dima.inc.singlemoduletemplate.data.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApi(): Api =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(
                OkHttpClient().newBuilder().addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                ).build()
            )
            .addConverterFactory(
                MoshiConverterFactory.create(
//                    Moshi.Builder()
                    //                      .add(MoshiArrayListJsonAdapter.FACTORY)
                    //  .add(KotlinJsonAdapterFactory())
                    //  .build()
                ).asLenient()
            )
            .build()
            .create(Api::class.java)
}