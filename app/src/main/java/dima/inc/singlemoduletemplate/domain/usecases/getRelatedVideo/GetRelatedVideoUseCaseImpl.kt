package dima.inc.singlemoduletemplate.domain.usecases.getRelatedVideo

import dima.inc.singlemoduletemplate.data.models.Video
import dima.inc.singlemoduletemplate.domain.repo.Repository
import javax.inject.Inject

class GetRelatedVideoUseCaseImpl @Inject constructor(
    private val repository: Repository,
) : GetRelatedVideoUseCase {
    
    override suspend operator fun invoke(video: Video) = repository.getRelatedVideoList(video)
}