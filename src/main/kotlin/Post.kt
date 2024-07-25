data class Post(
    var postId: Int? = null,
    var ownerId: Int = 0,
    var text: String? = null,
    var fromId: Int = 0,
    var view: WallService.View = WallService.View(),
    var likes: WallService.Likes = WallService.Likes(),
    var attachments: Array<Attachment> = emptyArray<Attachment>()

)

object WallService {

    private var posts = emptyArray<Post>()
    private var countWall: Int = 0
    private var comments = emptyArray<Comment>()

    fun createComment(postId: Int, comment: String): Comment {
        for ((index, post) in posts.withIndex()) {
            if (post.postId == postId) {
                var postComment: Comment = Comment(postId, comment)
                comments += postComment
                return comments.last()
            }
        }
        throw PostNotFoundException("Пост с данным ID не найден!")
    }


    fun clear() {
        posts = emptyArray()
        countWall = 0
    }

    fun add(post: Post): Post {
        countWall++
        posts += post.copy(postId = countWall)

        return posts.last()
    }

    fun update(updPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.postId == updPost.postId) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }


   data class Likes(var likeCount: Int = 0) {
        companion object {
            fun like(postLike: Post): Post {
                for ((index, post) in posts.withIndex()) {
                    if (postLike == post && post.likes.likeCount <= 0) {
                        post.likes.likeCount++
                        posts[index] = post.copy()
                       return posts[index]
                    } else if (postLike == post) {
                        post.likes.likeCount--
                        posts[index] = post.copy()
                       return posts[index]
                    }

                }
                return postLike
            }
        }
    }

   data class View(var viewCount: Int = 0) {

        companion object {
            fun view(post: Post): Post {
                post.view.viewCount++
                return post
            }
        }
    }

   data class Comment(var postId: Int = 0, var comment: String = "") {

    }

    class PostNotFoundException(message: String) : RuntimeException(message)

}

