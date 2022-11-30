package it.macgood.jsonplaceholder.data.remote

import it.macgood.jsonplaceholder.data.remote.dto.PostDto
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("/posts")
    suspend fun getPosts(): List<PostDto>
}