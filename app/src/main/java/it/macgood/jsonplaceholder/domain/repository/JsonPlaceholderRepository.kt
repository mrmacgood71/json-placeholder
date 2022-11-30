package it.macgood.jsonplaceholder.domain.repository

import it.macgood.jsonplaceholder.data.remote.dto.PostDto
import it.macgood.jsonplaceholder.data.remote.dto.UserDto

interface JsonPlaceholderRepository {

    suspend fun getPosts(): List<PostDto>

    suspend fun getUser(): UserDto
}