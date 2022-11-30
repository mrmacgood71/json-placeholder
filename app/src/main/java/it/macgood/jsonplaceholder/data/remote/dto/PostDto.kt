package it.macgood.jsonplaceholder.data.remote.dto

import it.macgood.jsonplaceholder.domain.model.Post

data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

fun PostDto.toPost(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}
