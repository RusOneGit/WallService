import org.junit.Test

import org.junit.Assert.*

class ChatServiceTest {

    @Test
    fun sendMessage(){
    }

    @Test
    fun print() {
    }

    @Test
    fun unreadChatsCount() {
       ChatService.sendMessage(1,Message("Hello"))
        val result = ChatService.unreadChatsCount()
        assertEquals(result, 1)

    }

    @Test
    fun lastMessages() {
        ChatService.sendMessage(1,Message("Hello"))
        ChatService.sendMessage(2,Message("Hello"))

        val result = ChatService.lastMessages()
        assertEquals(result.size, 3)
           }

    @Test
    fun getMessages() {
        ChatService.sendMessage(1,Message("Hello"))
        ChatService.sendMessage(1,Message("Hello"))
        val  result = ChatService.getMessages(1,2)
        assertEquals(result.size,2)
    }

    @Test
    fun deleteMessage() {

    }

    @Test
    fun deleteChat() {
    }
    @Test
    fun getChats(){
        ChatService.sendMessage(1,Message("Hello"))
        val result = ChatService.getChats()
        assertEquals(result.size, 2)
    }
}