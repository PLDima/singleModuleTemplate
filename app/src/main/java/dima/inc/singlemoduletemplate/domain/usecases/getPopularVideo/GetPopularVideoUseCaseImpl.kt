package dima.inc.singlemoduletemplate.domain.usecases.getPopularVideo

import dima.inc.singlemoduletemplate.domain.repo.Repository
import javax.inject.Inject

class GetPopularVideoUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : GetPopularVideoUseCase {

    override suspend operator fun invoke() = repository.getPopularVideo()
}