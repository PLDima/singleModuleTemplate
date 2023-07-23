package dima.inc.singlemoduletemplate.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dima.inc.singlemoduletemplate.domain.usecases.getPopularVideo.GetPopularVideoUseCase
import dima.inc.singlemoduletemplate.domain.usecases.getPopularVideo.GetPopularVideoUseCaseImpl
import dima.inc.singlemoduletemplate.domain.usecases.getRelatedVideo.GetRelatedVideoUseCase
import dima.inc.singlemoduletemplate.domain.usecases.getRelatedVideo.GetRelatedVideoUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule{

    @Binds
    fun bindGetPopularVideosUseCase(useCaseImpl: GetPopularVideoUseCaseImpl): GetPopularVideoUseCase

    @Binds
    fun bindGetRelatedVideoUseCase(useCaseImpl: GetRelatedVideoUseCaseImpl): GetRelatedVideoUseCase
}