import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    val post = Post()
    val post1 = Post(1)



    @Test
    fun add() {
        val result = WallService.add(post)
        assertEquals(1, result.id)

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
    fun updateFalse(){
        WallService.add(post)
        val result = WallService.update(post)
        assertEquals(true, result)
    }


}