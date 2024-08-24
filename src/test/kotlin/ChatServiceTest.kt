import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ChatServiceTest {

    @Before
    fun clear(){
        ChatService.clear()
    }
    @Test
    fun sendMessage(){

        val result = ChatService.sendMessage(1,Message("Hello"))
        assertEquals(true, result)
    }

    @Test
    fun unreadChatsCount() {
       ChatService.sendMessage(1,Message("Hello"))
        val result = ChatService.unreadChatsCount()
        assertEquals(1, result)

    }

    @Test
    fun lastMessages() {
        ChatService.sendMessage(1,Message("Hello"))
        ChatService.sendMessage(2,Message("Hello"))

        val result = ChatService.lastMessages()
        assertEquals(2, result.size)
           }

    @Test
    fun getMessages() {
        ChatService.sendMessage(1,Message("Hello"))
        ChatService.sendMessage(1,Message("Hello"))
        val  result = ChatService.getMessages(1,2)
        assertEquals(2, result.size)
    }

    @Test
    fun deleteMessage() {
        ChatService.sendMessage(1,Message("Hello"))
        val result = ChatService.deleteMessage(1,1)
        assertEquals(true, result)
    }

    @Test
    fun deleteChat() {
        ChatService.sendMessage(2,Message("Hello"))
        val result = ChatService.deleteChat(2)
        assertEquals(true, result)
    }
    @Test
    fun getChats(){
        ChatService.sendMessage(1,Message("Hello"))
        val result = ChatService.getChats()
        assertEquals(1, result.size)
    }
}