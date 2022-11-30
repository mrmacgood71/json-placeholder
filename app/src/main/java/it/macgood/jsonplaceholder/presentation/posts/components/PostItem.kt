package it.macgood.jsonplaceholder.presentation.posts.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import it.macgood.jsonplaceholder.domain.model.Post



@Composable
fun PostItem(
    post: Post,
    onItemClick: (Post) -> Unit
) {
        Card(modifier = Modifier
            .fillMaxWidth()

            .padding(8.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = 2.dp
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(post) }
                .padding(8.dp)
            ) {
                Text(
                    text = "user: ${(post.userId)}",
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "#" + post.id.toString(),
                    color = Color.LightGray,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = post.title,
                    modifier = Modifier.padding(1.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = post.body + " | ",
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }


