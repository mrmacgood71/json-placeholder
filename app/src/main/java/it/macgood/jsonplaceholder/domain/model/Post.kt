package it.macgood.jsonplaceholder.domain.model

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)