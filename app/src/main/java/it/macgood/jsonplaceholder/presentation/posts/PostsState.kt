package it.macgood.jsonplaceholder.presentation.posts

import it.macgood.jsonplaceholder.domain.model.Post

data class PostsState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
    val error: String = ""
) {
}