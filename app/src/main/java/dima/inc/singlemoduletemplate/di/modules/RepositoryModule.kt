package dima.inc.singlemoduletemplate.di.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dima.inc.singlemoduletemplate.domain.repo.MastodonRepository
import dima.inc.singlemoduletemplate.domain.repo.MastodonRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
internal interface RepositoryModule {

    @Binds
    fun bindMastodonRepositoryImpl(mastodonRepositoryImpl: MastodonRepositoryImpl): MastodonRepository
}