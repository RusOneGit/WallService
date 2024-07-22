data class Post(
    var id: Int? = null,
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


    fun clear() {
        posts = emptyArray()
        countWall = 0
    }

    fun add(post: Post): Post {
        countWall++
        posts += post.copy(id = countWall)

        return posts.last()
    }

    fun update(updPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == updPost.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
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

        override fun toString(): String {
            return likeCount.toString()
        }
    }

    class View(var viewCount: Int = 0) {

        companion object {
            fun view(post: Post): Int {
                post.view.viewCount++
                return post.view.viewCount
            }
        }

        override fun toString(): String {
            return viewCount.toString()
        }
    }

}

