package dima.inc.singlemoduletemplate.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dima.inc.singlemoduletemplate.data.api.datasource.YouTubeDataSource
import dima.inc.singlemoduletemplate.data.api.datasource.YouTubeDataSourceImpl

@Module
@InstallIn(ViewModelComponent::class)
interface SourceModule {

    @Binds
    fun bindYouTubeRemoteDataSource(youTubeRemoteDataSource: YouTubeDataSourceImpl): YouTubeDataSource
}