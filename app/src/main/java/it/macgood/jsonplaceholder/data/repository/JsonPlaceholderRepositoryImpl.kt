package it.macgood.jsonplaceholder.data.repository

import it.macgood.jsonplaceholder.data.remote.JsonPlaceholderApi
import it.macgood.jsonplaceholder.data.remote.dto.PostDto
import it.macgood.jsonplaceholder.domain.repository.JsonPlaceholderRepository
import javax.inject.Inject

class JsonPlaceholderRepositoryImpl @Inject constructor(
    private val api: JsonPlaceholderApi
) : JsonPlaceholderRepository {

    override suspend fun getPosts(): List<PostDto> {
        return api.getPosts()
    }
}