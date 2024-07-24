fun main() {
    val post = Post()
    // val post1 = Post(null ,text = "Пока")
    //  val post3 = Post()

    //  println(WallService.add(post3))
    WallService.add(post)
    // println(WallService.update(post1))
    println( WallService.createComment(1, "Hello"))

}