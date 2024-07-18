import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    private var posts = emptyArray<Post>()
    private var countWall: Int = 0
    val post = Post()
    val updPost = Post()
    @Test
    fun clear() {
        var posts = emptyArray<Post>()
        var countWall: Int = 0
        val result = 0
        assertEquals(0,0)

    }
    @Test
    fun add() {
        val result = post.id
        assertEquals(1, result)

    }

    @Test
    fun update() {
        updPost
        post

        posts
        val result = update()
        assertEquals(true, result)

    }


}