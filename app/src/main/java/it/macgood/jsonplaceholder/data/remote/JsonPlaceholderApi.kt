package it.macgood.jsonplaceholder.data.remote

import it.macgood.jsonplaceholder.data.remote.dto.PostDto
import it.macgood.jsonplaceholder.data.remote.dto.UserDto
import retrofit2.http.GET

interface JsonPlaceholderApi {

    @GET("/posts")
    suspend fun getPosts(): List<PostDto>

    @GET("users/{userId}")
    suspend fun getUser(): UserDto

}