data class Post(
    var id: Int = 0,
    var ownerId: Int = 0,
    var text: String = "",
    var fromId: Int = 0,
    var view: WallService.View = WallService.View(),
    val likes: WallService.Likes = WallService.Likes()

)

object WallService {

    private var posts = emptyArray<Post>()
    private var countWall: Int = 0


    fun add(post: Post): Post {

        val postIdent = post.copy(countWall + 1)
        countWall++
        posts += postIdent

        return posts.last()
    }

    fun update(updPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == updPost.id) {
                posts[index] = updPost
                return true
            }
        }
        return false
    }

    fun clear() {
        posts = emptyArray()
        countWall
    }

    class Likes(var likeCount: Int = 0) {
        companion object {
            fun like(postLike: Post): Int {
                for ((index, post) in posts.withIndex()) {
                    if (postLike == post && post.likes.likeCount <= 0) {
                        post.likes.likeCount++
                        posts[index] = post.copy()
                        return posts[index].likes.likeCount
                    } else if (postLike == post) {
                        post.likes.likeCount--
                        posts[index] = post.copy()
                        return posts[index].likes.likeCount
                    }

                }
                return postLike.likes.likeCount
            }
        }
    }

    class View(var viewCount: Int = 0) {

        companion object {
            fun view(post: Post): Int {
                post.view.viewCount++
                return post.view.viewCount
            }
        }
    }
}

