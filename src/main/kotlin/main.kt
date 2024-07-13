fun main() {
    val post = Post(0, 2, "Привет", 3, 0)
    val post1 = Post(1, 2, "Пока", 3, 0)
    WallService.add(post)
    WallService.viewFromId(1)
    println("Запись добавлена. ID записи: " + post.id)
    WallService.Likes.like(post)
    println("Лайк поставлен. Количество лайков: " + post.likes)
    WallService.Likes.like(post)
    println("Лайк убран. Количество лайков: " + post.likes)
    println(WallService.update(post1))
    WallService.viewFromId(1)
}

data class Post constructor(
    var id: Int = 0,
    val ownerId: Int = 0,
    val text: String = "",
    val fromId: Int = 0,
    var likes: Int = 0
)

object WallService {

    private var posts = emptyArray<Post>()


    fun add(post: Post): Post {
        posts += post

        post.id = posts.size
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


    fun viewFromId(id: Int) {
        for ((index, post) in posts.withIndex()) {
            if (post.id == id) {
                println(posts[index])
            } else {
                println("Нет совпадений")
            }
        }
    }

    object Likes {


        fun like(post: Post): Post {

            if (post.likes <= 0) {
                post.likes += 1
            } else {
                post.likes -= 1
            }

            return post
        }
    }
}

