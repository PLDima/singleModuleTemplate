package dima.inc.singlemoduletemplate.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dima.inc.singlemoduletemplate.domain.usecases.getPopularVideo.GetPopularVideoUseCase
import dima.inc.singlemoduletemplate.domain.usecases.getPopularVideo.GetPopularVideoUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule{

    @Binds
    fun bindUseCase(useCaseImpl: GetPopularVideoUseCaseImpl): GetPopularVideoUseCase
}