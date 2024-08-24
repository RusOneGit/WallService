import org.junit.Test

import org.junit.Assert.*


class NoteTest {


    @Test
    fun add() {
        val result = Note.add("Name", "...")
        assertEquals("Name", result.title)
    }

    @Test
    fun createComment() {
        Note.add("Test", "...")
        val result = Note.createComment(1, "Hello")
        assertEquals(true, result)
    }

    @Test
    fun delete() {
        Note.add("", "...")
        val result = Note.delete(1)
        assertEquals(true, result)
    }

    @Test
    fun deleteComment() {
        Note.add("Name", "...")
        Note.createComment(1, "Hello")
        val result = Note.deleteComment(1, 1)
        assertEquals(true, result)
    }

    @Test
    fun edit() {
        Note.add("Name", "...")
        val result = Note.edit(1, "Names", "edit")
        assertEquals(true, result)
    }

    @Test
    fun editComment() {
        Note.add("Name", "...")
        Note.createComment(1, "Hello")
        val result = Note.editComment(1, 1, "Bye")
        assertEquals(true, result)
    }

    @Test
    fun restoreComment() {
        Note.add("Name", "...")
        Note.createComment(1, "Hello")
        Note.deleteComment(1, 1)
        val result = Note.restoreComment(1,1)
        assertEquals(true, result)
    }

    @Test
    fun getByID() {
        Note.add("Name", "...")
        Note.add("Names",",,,")
        val result = Note.getByID(2)
        assertEquals(",,,", result.content)

    }

    @Test
    fun getComment() {
        Note.add("Name", "...")
        Note.createComment(1, "Hello")
        val result = Note.getComment(1)
        assertEquals("Hello", result[0].message)

    }

    @Test
    fun get() {
        Note.add("Name", "...")
        Note.add("Names",",,,")
        val result = Note.get("1,2")
        assertEquals("Names", result[1].title)


    }
}