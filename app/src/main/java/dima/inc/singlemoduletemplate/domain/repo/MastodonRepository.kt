package dima.inc.singlemoduletemplate.domain.repo

interface MastodonRepository{
    suspend fun getInstances()
}