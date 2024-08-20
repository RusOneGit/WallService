data class Chat(val messages: MutableList<Message> = mutableListOf())

data class Message(val text: String, var statusMessage: Boolean = false)
object ChatService {
    private val chats = mutableMapOf<Int, Chat>(100 to Chat())
    fun sendMessage(userID: Int, message: Message) {
        chats.getOrPut(userID) { Chat() }.messages += message
    }
    fun print(){
        println(chats)
    }
    fun unreadChatsCount() = chats.values.count { it.messages.any { !it.statusMessage } }

    fun lastMessages() = chats.values.map { it.messages.lastOrNull()?.text ?: "Нет сообщений!" }

    fun getMessages(userID: Int, count: Int): List<Message> {
        val chat = chats[userID] ?: throw NoSuchChatException()
        return chat.messages.takeLast(count).onEach { it.statusMessage = true }
    }

    fun deleteMessage(userID: Int, numberMessage: Int) {
        val chat = chats[userID] ?: throw NoSuchChatException()
        chats.getOrPut(userID) { Chat() }.messages.removeAt(numberMessage - 1)
    }

    fun deleteChat(userID: Int){
        val chat = chats[userID] ?: throw NoSuchChatException()
      chats.remove(userID)
    }

    fun getChats(){
        println(chats)
    }
}


class NoSuchChatException : Throwable() {

}

