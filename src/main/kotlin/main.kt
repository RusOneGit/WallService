fun main() {
    val post = Post()
    // val post1 = Post(null ,text = "Пока")
    //  val post3 = Post()

    //  println(WallService.add(post3))
    // WallService.add(post3)
    // println(WallService.update(post1))


    val video: Attachment = AttachmentVideo(Video)
    val audio: Attachment = AttachmentAudio(Audio)
    val photo: Attachment = AttachmentPhoto(Photo)
    val note: Attachment = AttachmentNote(Note)
    val document: Attachment = AttachmentDocument(Document)
    attachments += video
    attachments += audio
    attachments += photo
    attachments += note
    attachments += document

}