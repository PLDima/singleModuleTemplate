package dima.inc.singlemoduletemplate.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dima.inc.singlemoduletemplate.domain.usecases.UseCase
import dima.inc.singlemoduletemplate.domain.usecases.UseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindUseCase(useCase: UseCaseImpl): UseCase
}