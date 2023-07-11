package dima.inc.singlemoduletemplate.domain.usecases.searchVideo

import dima.inc.singlemoduletemplate.domain.repo.Repository
import javax.inject.Inject

class SearchVideoUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : SearchVideoUseCase {

    override suspend operator fun invoke(request: String) = repository.searchVideoList(request)
}