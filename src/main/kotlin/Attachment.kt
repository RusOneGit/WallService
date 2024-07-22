abstract class Attachment(val type: String)

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

data class Note(
    val id: Int = 1,
    val title: String = "название заметки",
    val content: String = "содержимое заметки"
)
