abstract class Attachment(val type: String)

var noteId = 0
val Notes: MutableList<Note> = mutableListOf()

class AttachmentVideo(val video: Video) : Attachment("video")

data class Video(
    val id: Int = 1,
    val title: String = "название видео",
    val description: String = "описание видео"
)

class AttachmentAudio(val audio: Audio) : Attachment("audio")

data class Audio(
    val id: Int = 1,
    val artist: String = "исполнитель",
    val title: String = "название композиции"
)

class AttachmentPhoto(val photo: Photo) : Attachment("photo")
data class Photo(
    val id: Int = 1,
    val url: String = "ссылка"
)


class AttachmentDocument(val document: Document) : Attachment("document")
data class Document(
    val id: Int = 1,
    val title: String = "название файла",
    val ext: String = "расширение файла"

)

class AttachmentNote(val note: Note) : Attachment("note")
data class Comments(
    val comNotId: Int = 0,
    var message: String = "",
    var access: String = "public"

) {
    override fun toString(): String {
        if (access == "public") return message else return "-"
    }
}

data class Note(
    var id: Int = 0,
    val title: String = "название заметки",
    val content: String = "содержимое заметки",
    val comment: MutableList<Comments> = mutableListOf(),
    var commentCount: Int = 0
) {
    companion object {
        fun add(title: String, content: String): Note {
            noteId++
            val note = Note(id = noteId, title, content)
            Notes.add(note)
            return note
        }

        fun createComment(notesId: Int, message: String): Boolean {
            for ((index, note) in Notes.withIndex()) {
                if (note.id == notesId) {
                    note.commentCount++
                    Notes[index].comment.add(Comments(note.commentCount, message))
                    return true
                }

            }

            return false
        }

        fun delete(noteId: Int): Boolean {
            for ((index, note) in Notes.withIndex()) {
                if (note.id == noteId) {
                    Notes.removeAt(index)
                    return true
                }
            }
            return false
        }


        fun deleteComment(notesId: Int, comId: Int): Boolean {
            for ((y, note) in Notes.withIndex()) {
                for ((i: Int, comments: Comments) in note.comment.withIndex())
                    if (note.id == notesId && comments.comNotId == comId) {
                        Notes[y].comment[i].access = "delete"
                        note.commentCount--
                        return true
                    }


            }
            return false
        }

        fun edit(notesId: Int, title: String, content: String): Boolean {
            for ((index, note) in Notes.withIndex()) {
                if (note.id == notesId) {
                    Notes[index] = note.copy(notesId, title, content)
                    return true
                }
            }
            return false
        }

        fun editComment(notesId: Int, comId: Int, message: String): Boolean {
            for ((y, note) in Notes.withIndex()) {
                for ((i: Int, comments: Comments) in note.comment.withIndex())
                    if (note.id == notesId && comments.comNotId == comId) {
                        Notes[y].comment[i].message = message

                        return true
                    }

            }
            return false
        }

        fun restoreComment(notesId: Int, comId: Int): Boolean {
            for ((y, note) in Notes.withIndex()) {
                for ((i: Int, comments: Comments) in note.comment.withIndex())
                    if (note.id == notesId && comments.comNotId == comId) {
                        Notes[y].comment[i].access = "public"
                        note.commentCount++
                        return true
                    }
            }
            return false
        }


        fun getByID(notesId: Int): Note {
            for ((y, note) in Notes.withIndex()) {
                if (note.id == notesId) {
                    return note
                }
            }
            throw NoteNotFoundException("Заметка с данным ID не найдена!")
        }


        fun getComment(notesId: Int): MutableList<Comments> {
            for ((y, note) in Notes.withIndex()) {
                if (note.id == notesId) {
                    return Notes[y].comment
                }

            }
            throw NoteNotFoundException("Комменарии к заметке с данным ID не найдены!")
        }


        fun get(noteListID: String): MutableList<Note> {
            val split = noteListID.split(",")
            val strings = split.map { it.toString().toInt() }.toIntArray()
            var noteList: MutableList<Note> = mutableListOf()


            for ((x, note) in Notes.withIndex()) {
                for ((y, string) in strings.withIndex())
                    if (string == note.id) {
                        noteList.add(note)
                    }

            }
            if (noteList.size>0) return noteList else
                throw NoteNotFoundException("Заметкис данными ID не найдены!")
        }

    }

    class NoteNotFoundException(message: String) : RuntimeException(message)

}