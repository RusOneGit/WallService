abstract class Attachment(val type: String) {

}

class AttachmentVideo(val video: Video) : Attachment("video") {
}

object Video {
    val id: Int = 1
    val title: String = "название видео"
    val description: String = "описание видео"
}

class AttachmentAudio(val audio: Audio) : Attachment("audio") {
}

object Audio {
    val id: Int = 1
    val artist: String = "исполнитель"
    val title: String = "название композиции"

}

class AttachmentPhoto(val photo: Photo) : Attachment("photo") {

}

object Photo {
    val id: Int = 1
    val url: String = "ссылка"

}


class AttachmentDocument(val document: Document) : Attachment("document") {
}

object Document {
    val id: Int = 1
    val title: String = "название файла"
    val ext: String = "расширение файла"

}


class AttachmentNote(val note: Note) : Attachment("note") {
}

object Note {
    val id: Int = 1
    val title: String = "название заметки"
    val content: String = "содержимое заметки"

}
