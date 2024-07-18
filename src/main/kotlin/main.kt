fun main() {
    val post = Post(0, text = "Привет")
    val post1 = Post(3,text = "Пока")
    val post3 = Post(0)

    WallService.add(post)
    WallService.add(post3)

    println(WallService.update(post1))





}