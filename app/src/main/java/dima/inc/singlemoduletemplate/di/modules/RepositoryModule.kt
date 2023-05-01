package dima.inc.singlemoduletemplate.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dima.inc.singlemoduletemplate.data.repo.RepositoryImpl
import dima.inc.singlemoduletemplate.domain.repo.ArticlesRepository

@Module
@InstallIn(ViewModelComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindRepository(repositoryImpl: RepositoryImpl): ArticlesRepository
}