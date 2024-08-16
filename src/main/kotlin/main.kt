fun main() {
    val post = Post()
    val post1 = Post(null, text = "Пока")
    println(Note.add("gg", "izi"))
    println( Note.createComment(1, "Hi"))
    println( Note.createComment(1, "Hy"))
    println( Note.createComment(1, "Ha"))


    println(Notes[0])
    println(Note.add("Hello", "Bye"))
    println(Note.delete(4))
    println(Note.edit(1,"lol", "kek"))
    println(Notes[0])
    println(Note.deleteComment(1,1))
    println(Notes[0])
  println(Note.editComment(1,2,"Hah"))
    println(Note.restoreComment(1,1))
    println(Notes[0])
    println(Note.getComment(1))
    println(Note.get("1,2"))



}