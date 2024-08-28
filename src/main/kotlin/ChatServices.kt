data class Chat(val messages: MutableList<Message> = mutableListOf())

data class Message(val text: String, var statusMessage: Boolean = false)

object ChatService {
    private var chats = mutableMapOf<Int, Chat>(100 to Chat())

    fun clear() {
        chats = mutableMapOf()
    }

    fun sendMessage(userID: Int, message: Message): Boolean {
        chats.getOrPut(userID) { Chat() }.messages += message
        return true
    }

    fun unreadChatsCount(): Int {
        return chats.asSequence()
            .map { it.value.messages.asSequence().any { !it.statusMessage } }
            .count { it }
    }

    fun lastMessages(): List<String> {
        return chats.asSequence()
            .map { it.value.messages.asSequence().lastOrNull()?.text ?: "Нет сообщений!" }
            .toList()
    }

    fun getMessages(userID: Int, count: Int): List<Message> {
        val chat = chats[userID] ?: throw NoSuchChatException()
        return chat.messages.takeLast(count).onEach { it.statusMessage = true }
    }

    fun deleteMessage(userID: Int, numberMessage: Int): Boolean {
        val chat = chats[userID] ?: throw NoSuchChatException()
        chats.getOrPut(userID) { Chat() }.messages.removeAt(numberMessage - 1)
        return true
    }

    fun deleteChat(userID: Int): Boolean {
        return chats.remove(userID) != null
    }

    fun getChats(): MutableMap<Int, Chat> {
        return chats
    }
}

class NoSuchChatException : Throwable()
