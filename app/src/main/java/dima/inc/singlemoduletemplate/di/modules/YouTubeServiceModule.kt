package dima.inc.singlemoduletemplate.di.modules

import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.youtube.YouTube
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object YouTubeServiceModule {

    @Provides
    fun provideYouTubeService(): YouTube {
        val httpTransport = NetHttpTransport()
        val jsonFactory = JacksonFactory.getDefaultInstance()
        return YouTube.Builder(httpTransport, jsonFactory, null)
            .build()
    }
}