package it.macgood.jsonplaceholder.domain.usecase

import it.macgood.jsonplaceholder.common.Resource
import it.macgood.jsonplaceholder.domain.model.User
import it.macgood.jsonplaceholder.domain.repository.JsonPlaceholderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetUser @Inject constructor(
    val repository: JsonPlaceholderRepository
) {
    operator fun invoke(userId: Int): Flow<Resource<User>> = flow {

    }
}