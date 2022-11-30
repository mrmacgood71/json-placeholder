package it.macgood.jsonplaceholder.domain.usecase

import it.macgood.jsonplaceholder.common.Resource
import it.macgood.jsonplaceholder.data.remote.dto.toPost
import it.macgood.jsonplaceholder.domain.model.Post
import it.macgood.jsonplaceholder.domain.repository.JsonPlaceholderRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPosts @Inject constructor(
    private val repository: JsonPlaceholderRepository
) {

    operator fun invoke(): Flow<Resource<List<Post>>> = flow {
        try {
            emit(Resource.Loading<List<Post>>())
            val posts = repository.getPosts().map { it.toPost() }
            emit(Resource.Success<List<Post>>(posts))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Post>>(e.localizedMessage ?: "Unexpeted error"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Post>>("" +
                    "Something went wrong. Check your Internet connection"
            ))
        }

    }
}