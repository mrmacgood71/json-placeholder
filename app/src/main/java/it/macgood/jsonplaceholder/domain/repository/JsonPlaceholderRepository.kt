package it.macgood.jsonplaceholder.domain.repository

import it.macgood.jsonplaceholder.data.remote.dto.PostDto

interface JsonPlaceholderRepository {

    suspend fun getPosts(): List<PostDto>
}