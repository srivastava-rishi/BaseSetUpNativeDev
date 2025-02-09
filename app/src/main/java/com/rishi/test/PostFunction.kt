package com.rishi.test

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID


// existingList
var existingList = mutableListOf(Post().initialState())

// Structure of postts

data class Post(
    val id: String = "",
    val likes: String = "",
    val comments: List<Comment> = emptyList()
) {
    fun initialState() = Post(
        id = "001",
        likes = "5",
        comments = listOf(
            Comment(
                id = "22",
                comment = "dbvsczaXScdv "
            ),
            Comment(
                id = "22",
                comment = "dbvsczaXScdv "
            ),
        )
    )
}

data class Comment(
    val id: String,
    val comment: String
)


fun addCommentInPost() {
    CoroutineScope(Dispatchers.IO).launch {
        val data = Comment(
            id = UUID.randomUUID().toString(),
            comment = "jiiii"
        )
        addComment(data)
    }

}


suspend fun addComment(data: Comment) {
    delay(1000)
    val existingComment = existingList[0].comments.toMutableList()
    existingComment.add(data)
}
