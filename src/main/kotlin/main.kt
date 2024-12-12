fun main() {


    println(ChatService.sendMessage(1, Message("Hello", statusMessage = false)))
    println(ChatService.unreadChatsCount())
    println(ChatService.deleteMessage(1,2))

}