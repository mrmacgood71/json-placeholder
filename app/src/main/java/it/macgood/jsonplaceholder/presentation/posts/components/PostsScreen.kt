package it.macgood.jsonplaceholder.presentation.posts.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import it.macgood.jsonplaceholder.presentation.posts.PostsViewModel


@Composable
fun PostsScreen(
    viewModel: PostsViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.posts) {post ->
                PostItem(post = post, onItemClick = {
                    Toast.makeText(
                        context,
                        "fadsf",
                        Toast.LENGTH_SHORT
                    )
                })
            }
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }

}
