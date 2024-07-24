import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    private val post = Post(0, text = "Hello, Kotlin")
    private val post1 = Post(1, text = "Hello, Kotlin")


    @Test
    fun add() {
        val result = WallService.add(post)
        assertEquals(1, result.postId)

    }

    @Before
    fun clear() {
        WallService.clear()
    }

    @Test
    fun update() {
        WallService.add(post)
        val result = WallService.update(post1)
        assertEquals(true, result)

    }

    @Test
    fun updateFalse() {
        WallService.add(post)
        val result = WallService.update(post)
        assertEquals(false, result)
    }


}