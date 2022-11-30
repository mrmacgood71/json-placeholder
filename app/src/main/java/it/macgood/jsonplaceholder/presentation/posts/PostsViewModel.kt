package it.macgood.jsonplaceholder.presentation.posts

import android.view.View
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import it.macgood.jsonplaceholder.common.Resource
import it.macgood.jsonplaceholder.domain.usecase.GetPosts
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val getPostsUseCase: GetPosts
) : ViewModel() {

    private val _state = mutableStateOf(PostsState())
    val state: State<PostsState> = _state

    init {
        getPosts()
    }

    private fun getPosts() {
        getPostsUseCase().onEach { resource ->
            when(resource) {
                is Resource.Success -> {
                    _state.value = PostsState(posts = resource.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = PostsState(true)
                }
                is Resource.Error -> {
                    _state.value = PostsState(error = resource.message ?: "Unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }


}